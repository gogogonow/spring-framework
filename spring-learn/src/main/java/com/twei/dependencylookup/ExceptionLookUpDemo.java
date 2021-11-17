package com.twei.dependencylookup;

import com.twei.beandefinition.po.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * bean提供者查找演示
 * Spring 5.1 Bean 延迟查找
 * @author 61404
 * @date 2021/11/13
 */
public class ExceptionLookUpDemo {
	public static void main(String[] args) {
		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 将当前类 TypeSafetyDependencyLookupDemo 作为配置类（Configuration Class）
		applicationContext.register(ExceptionLookUpDemo.class);
		// 启动应用上下文
		applicationContext.refresh();

		// 演示 BeanFactory#getBean 方法的安全性
		displayBeanFactoryGetBean(applicationContext);
		// 演示 ObjectFactory#getObject 方法的安全性
		displayObjectFactoryGetObject(applicationContext);
		// 演示 ObjectProvider#getIfAvaiable 方法的安全性
		displayObjectProviderIfAvailable(applicationContext);

		// 演示 ListableBeanFactory#getBeansOfType 方法的安全性
		displayListableBeanFactoryGetBeansOfType(applicationContext);
		// 演示 ObjectProvider Stream 操作的安全性
		displayObjectProviderStreamOps(applicationContext);

		// 关闭应用上下文
		applicationContext.close();
	}

	private static void displayObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<Person> personObjectProvider = applicationContext.getBeanProvider(Person.class);
		printBeansException("displayObjectProviderStreamOps", () -> personObjectProvider.forEach(System.out::println));
	}

	private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory) {
		printBeansException("displayListableBeanFactoryGetBeansOfType", () -> beanFactory.getBeansOfType(Person.class));
	}

	private static void displayObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<Person> personObjectProvider = applicationContext.getBeanProvider(Person.class);
		printBeansException("displayObjectProviderIfAvailable", personObjectProvider::getIfAvailable);
	}

	private static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {
		// ObjectProvider is ObjectFactory
		ObjectFactory<Person> personObjectProvider = applicationContext.getBeanProvider(Person.class);
		printBeansException("displayObjectFactoryGetObject", personObjectProvider::getObject);
	}

	public static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
		printBeansException("displayBeanFactoryGetBean", () -> beanFactory.getBean(Person.class));
	}

	private static void printBeansException(String source, Runnable runnable) {
		System.err.println("==========================================");
		System.err.println("Source from :" + source);
		try {
			runnable.run();
		} catch (BeansException exception) {
			exception.printStackTrace();
		}
	}
}
