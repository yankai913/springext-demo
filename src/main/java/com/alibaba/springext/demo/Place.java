package com.alibaba.springext.demo;

import com.google.gson.Gson;


public class Place {

    private Country country;


    public Country getCountry() {
        return country;
    }


    public void setCountry(Country country) {
        this.country = country;
    }


    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
