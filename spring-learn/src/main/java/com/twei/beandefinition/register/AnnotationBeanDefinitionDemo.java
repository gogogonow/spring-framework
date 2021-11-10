package com.twei.beandefinition.register;

import com.twei.beandefinition.po.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 注释bean定义演示
 *
 * @author 61404
 * @date 2021/10/27
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AnnotationBeanDefinitionDemo.class);
		applicationContext.refresh();
		Map<String, Config> cfgBeans = applicationContext.getBeansOfType(Config.class);
		Map<String, Person> personBeans = applicationContext.getBeansOfType(Person.class);
		System.out.println(cfgBeans);
		System.out.println(personBeans);
		applicationContext.close();
	}

	@Component
	public static class Config {

		@Bean(name = {"ppp"})
		public Person person() {
			Person person = new Person();
			person.setName("kk");
			person.setAge(11);
			return person;
		}
	}
}
