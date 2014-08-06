package com.alibaba.springext.demo.parser;

import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.alibaba.springext.demo.CountryImpl;


public class CountryDefinitionParser extends AbstractSingleBeanDefinitionParser {
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        builder.addPropertyValue("desc", element.getAttribute("desc"));
        Map<String, Object> countryMap = new ManagedMap<String, Object>();
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            Element ele = (Element) node;
            BeanDefinitionParserDelegate delegate = parserContext.getDelegate();
            BeanDefinition containingBean = builder.getRawBeanDefinition();
            AbstractBeanDefinition beanDefinition =
                    (AbstractBeanDefinition) delegate.parseCustomElement(ele, containingBean);
            String beanName = ele.getAttribute("id");
            if (beanName == null || beanName.length() == 0) {
                beanName =
                        BeanDefinitionReaderUtils.generateBeanName(beanDefinition,
                            parserContext.getRegistry(), true);
            }
            BeanDefinitionHolder innerHoler = new BeanDefinitionHolder(beanDefinition, beanName);
            countryMap.put(innerHoler.getBeanName(), innerHoler);
        }
        builder.addPropertyValue("countryMap", countryMap);
        BeanDefinitionRegistry registry = parserContext.getRegistry();
        BeanDefinitionHolder definitionHolder =
                new BeanDefinitionHolder(builder.getBeanDefinition(), "country", new String[]{"country2"});
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
    }


    protected Class<?> getBeanClass(Element element) {
        return CountryImpl.class;
    }
}
