package com.alibaba.springext.demo;

import java.util.Map;

import com.google.gson.Gson;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2014-7-27
 */
public class CountryImpl implements Country {

    private String desc;

    private Map<String, Object> countryMap;


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }


    public Map<String, Object> getCountryMap() {
        return countryMap;
    }


    public void setCountryMap(Map<String, Object> countryMap) {
        this.countryMap = countryMap;
    }


    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
