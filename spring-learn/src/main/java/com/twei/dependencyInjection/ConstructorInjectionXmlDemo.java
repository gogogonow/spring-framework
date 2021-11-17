package com.twei.dependencyInjection;

import com.twei.general.ioc.javabeans.PersonHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 构造函数注入xml演示
 *
 * @author 61404
 * @date 2021/11/17
 */
public class ConstructorInjectionXmlDemo {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

		String xmlResourcePath = "classpath:/injection/constructor-injection-bean.xml";
		// 加载 XML 资源，解析并且生成 BeanDefinition
		beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
		// 依赖查找并且创建 Bean
		PersonHolder personHolder = beanFactory.getBean(PersonHolder.class);
		System.out.println(personHolder);
	}
}
