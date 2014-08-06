package com.alibaba.springext.demo.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.alibaba.springext.demo.parser.CountryDefinitionParser;


public class PlacesNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("country", new CountryDefinitionParser());
    }
}
