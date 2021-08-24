package edu.escuelaing.arep;

import static spark.Spark.*;

import spark.Request;
import spark.Response;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class App 
{
    public static void main( String[] args )
    {
        port(getPort());
        // root is 'src/main/resources', so put files in 'src/main/resources/public'
        staticFiles.location("/public");
        get("/hello", (req, res) -> "Hello World");
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
        get("/getfb", (req, res) -> getFbData(req, res));
        get("/getTime/:symbol/:function", (req, res) -> getXData(req, res));
    }

    private static String getXData(Request req, Response res){
        res.type("application/json");
        String stock = req.params(":symbol");
        String function = req.params(":function");
        String response = "None";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getService();

        if(stock != null && stock != ""){
            stockService.setUrl(function);
            stockService.setStock(stock);
        }
        try {
            response = stockService.getFbData();
        }
        catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    private static String getFbData(Request req, Response res){
        String stock = req.queryParams("st");
        String response = "None";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getService();
        if(stock != null && stock != ""){
            stockService.setUrl("daily");
            stockService.setStock(stock);
        }
        try {
            response = stockService.getFbData();
        }
        catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>HTML Forms</h2>"
                + "<form action=\"/results\">"
                + "  First name:<br>"
                + "  <input type=\"text\" name=\"firstname\" value=\"Mickey\">"
                + "  <br>"
                + "  Last name:<br>"
                + "  <input type=\"text\" name=\"lastname\" value=\"Mouse\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        return req.queryParams("firstname") + " " +
                req.queryParams("lastname");
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
