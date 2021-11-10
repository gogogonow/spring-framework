package com.twei.beandefinition.register;

import com.twei.beandefinition.po.Person;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * apibean定义演示
 *
 * @author 61404
 * @date 2021/10/27
 */
public class APIBeanDefinitionDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 带名称的注册
		registerBeanDefinition(applicationContext, "hhhh", Person.class);
		// 不带名称的注册
		registerBeanDefinition(applicationContext, Person.class);
		applicationContext.refresh();
		Map<String, Person> bean = applicationContext.getBeansOfType(Person.class);
		System.out.println(bean);
		applicationContext.close();
	}

	private static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
		AbstractBeanDefinition beanDefinition = builder
						.addPropertyValue("name", "kkkk")
						.addPropertyValue("age", 22).getBeanDefinition();
		if (StringUtils.hasText(beanName)) {
			registry.registerBeanDefinition(beanName, beanDefinition);
		}
		else {
			BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
		}
	}


	private static void registerBeanDefinition(BeanDefinitionRegistry registry, Class<?> beanClass) {
		registerBeanDefinition(registry, null, beanClass);
	}
}
