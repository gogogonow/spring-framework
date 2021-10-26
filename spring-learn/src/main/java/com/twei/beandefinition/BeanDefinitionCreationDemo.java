package com.twei.beandefinition;

import com.twei.beandefinition.bean.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * 创建的bean定义演示
 *
 * @author 61404
 * @date 2021/10/26
 */
public class BeanDefinitionCreationDemo {

	public static void main(String[] args) {
		// 1、通过 BeanDefinitionBuilder创建BeanDefinition
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
		beanDefinitionBuilder.addPropertyValue("name", "tom").addPropertyValue("age", 30);
		AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

		// 2、通过 AbstractBeanDefinition 以及派生类创建
		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
		genericBeanDefinition.setBeanClass(Person.class);
		MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
		mutablePropertyValues.add("name", "tom").add("age", 30);
		genericBeanDefinition.setPropertyValues(mutablePropertyValues);
	}
}
