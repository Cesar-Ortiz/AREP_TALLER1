package edu.escuelaing.arep;

import java.util.HashMap;

public class CacheData {
    private HashMap<String, String> cache = new HashMap<>();
    private String key = "";

    public void saveCache(String symbol, String funcion, String data){
        key= symbol+funcion;
        cache.put(key, data);
    }
    public String getCache(String symbol, String funcion){
        key= symbol+funcion;
        String data= "";
        if (cache.containsKey(key)){
            data=cache.get(key);
        }
        return data;
    }
}
