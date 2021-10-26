package com.twei.beandefinition;

import com.twei.beandefinition.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 豆别名演示
 *
 * @author 61404
 * @date 2021/10/26
 */
public class BeanAliasDemo {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-alias.xml");
		Person tweiPerson = beanFactory.getBean("twei-person", Person.class);
		Person person = beanFactory.getBean("person", Person.class);
		System.out.println("twei-person 和 person 是否相等：" + (tweiPerson == person));
	}
}
