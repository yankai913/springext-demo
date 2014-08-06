package com.alibaba.springext.demo.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.alibaba.springext.demo.parser.ChinaDefinitionParser;
import com.alibaba.springext.demo.parser.UsaDefinitionParser;


public class PlacesCountriesNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("china", new ChinaDefinitionParser());
        registerBeanDefinitionParser("usa", new UsaDefinitionParser());
    }
}
