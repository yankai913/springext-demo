package com.alibaba.springext.demo.parser;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alibaba.springext.demo.China;


public class ChinaDefinitionParser extends AbstractSingleBeanDefinitionParser {
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        builder.addPropertyValue("name", element.getAttribute("name"));
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if ("language".equals(node.getLocalName())) {
                builder.addPropertyValue("language", node.getTextContent());
            }
        }
    }


    protected Class<?> getBeanClass(Element element) {
        return China.class;
    }

}
