package edu.escuelaing.arep;

public class AlphaHttpStockService extends HttpStockService{

    String stock="fb";
    String time="";

    @Override
    public String getUrl() {
        String url="";
        if (time.equals("intra")) {
            url= "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="+stock+"&interval=5min&apikey=A1TWI206BXZQBL63";
        }
        else if (time.equals("daily")) {
            url= "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+stock+"&apikey=A1TWI206BXZQBL63";
        }
        else if (time.equals("weekly")) {
            url= "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol="+stock+"&apikey=A1TWI206BXZQBL63";
        }
        else if (time.equals("monthly")) {
            url= "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol="+stock+"&apikey=A1TWI206BXZQBL63";
        }
        return url;
    }

    @Override
    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public void setUrl(String time) {
        this.time = time;
    }
}
