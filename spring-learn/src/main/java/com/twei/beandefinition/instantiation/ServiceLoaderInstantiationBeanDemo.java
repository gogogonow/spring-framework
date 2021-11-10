package com.twei.beandefinition.instantiation;

import com.twei.beandefinition.factory.PersonFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 静态方法实例化bean演示
 *
 * @author 61404
 * @date 2021/11/10
 */
public class ServiceLoaderInstantiationBeanDemo {
	public static void main(String[] args) {
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:instantiation/service-loader-bean.xml");
//		ServiceLoader<PersonFactory> serviceLoader = beanFactory.getBean("service-loader-for-person-factory", ServiceLoader.class);
//		Iterator<PersonFactory> iterator = serviceLoader.iterator();
//		while (iterator.hasNext()) {
//			PersonFactory next = iterator.next();
//			System.out.println(next.createPerson());
//		}
//		displayServiceLoader();
	}

	public static void displayServiceLoader() {
		ServiceLoader<PersonFactory> serviceLoader = ServiceLoader.load(PersonFactory.class, Thread.currentThread().getContextClassLoader());
		Iterator<PersonFactory> iterator = serviceLoader.iterator();
		while (iterator.hasNext()) {
			PersonFactory next = iterator.next();
			System.out.println(next.createPerson());
		}
	}
}
