package com.twei.beandefinition;

import com.twei.beandefinition.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * 注释bean定义演示
 *
 * @author 61404
 * @date 2021/10/27
 */
@Import(AnnotationBeanDefinitionDemo.class)
public class AnnotationBeanDefinitionDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(Config.class);
		applicationContext.refresh();
		Person bean = applicationContext.getBean("ppp", Person.class);
		System.out.println(bean.toString());
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
