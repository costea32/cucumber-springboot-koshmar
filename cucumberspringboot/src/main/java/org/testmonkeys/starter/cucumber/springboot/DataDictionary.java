package org.testmonkeys.starter.cucumber.springboot;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataDictionary {

    private Map<String,Object> dictionary = new HashMap<>();

    public void add(String key, Object value){
        dictionary.put(key,value);
    }

    public <T> T get(String key){
        return (T)dictionary.get(key);
    }
}
