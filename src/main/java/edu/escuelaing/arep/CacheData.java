package edu.escuelaing.arep;

import java.util.HashMap;

public class CacheData {
    private HashMap<String, String> cache = new HashMap<>();

    public String getCache(String key){
        String data= "";
        if (cache.containsKey(key)){
            data=cache.get(key);
        }
        return data;
    }

    public void saveCache(String key, String data) {
        cache.put(key, data);
    }
}
