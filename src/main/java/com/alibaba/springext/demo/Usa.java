package com.alibaba.springext.demo;

import com.google.gson.Gson;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2014-7-27
 */
public class Usa implements Country {

    private String name;

    private String language;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getLanguage() {
        return language;
    }


    public void setLanguage(String language) {
        this.language = language;
    }


    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
