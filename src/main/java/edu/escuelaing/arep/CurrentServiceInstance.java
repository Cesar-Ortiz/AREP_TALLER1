package edu.escuelaing.arep;

public class CurrentServiceInstance {
    private static CurrentServiceInstance _instance = new CurrentServiceInstance();
    private HttpStockService service;

    private CurrentServiceInstance(){
        service = new AlphaHttpStockService();
    }

    public static CurrentServiceInstance getInstance(){
        return _instance;
    }

    public HttpStockService getService(){
        return service;
    }
}
