package com.twei.dependencyInjection;

import com.twei.beandefinition.po.Person;
import com.twei.general.ioc.javabeans.PersonHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 原生的xml注入演示
 *
 * @author 61404
 * @date 2021/11/17
 */
public class PrimitiveInjectionXmlDemo {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

		String xmlResourcePath = "classpath:/bean/bean.xml";
		// 加载 XML 资源，解析并且生成 BeanDefinition
		beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
		// 依赖查找并且创建 Bean
		Person person = beanFactory.getBean(Person.class);
		System.out.println(person);
	}
}
