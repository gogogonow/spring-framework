package com.twei.beandefinition.instantiation;

import com.twei.beandefinition.po.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 静态方法实例化bean演示
 *
 * @author 61404
 * @date 2021/11/10
 */
public class FactoryBeanInstantiationBeanDemo {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:instantiation/factory-bean.xml");
		Person bean = beanFactory.getBean(Person.class);
		System.out.println(bean);
	}
}