package com.twei.beandefinition.load;

import com.twei.beandefinition.po.Person;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * bean定义加载演示
 *
 * @author 61404
 * @date 2021/10/24
 */
public class BeanDefinitionLoadDemo {
	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("bean/bean.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		Person person = factory.getBean("person", Person.class);
	}
}
