package com.alibaba.springext.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    @SuppressWarnings("resource")
    static void start_1() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        CountryImpl country = (CountryImpl) ctx.getBean("country2");
        System.out.println(country);
        Place place = (Place) ctx.getBean("place");
        System.out.println(place);
    }


    public static void main(String[] args) throws Exception {
        start_1();
    }

}
