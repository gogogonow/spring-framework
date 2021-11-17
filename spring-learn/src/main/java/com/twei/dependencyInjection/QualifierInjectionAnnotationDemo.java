package com.twei.dependencyInjection;

import com.twei.beandefinition.po.Person;
import com.twei.dependencyInjection.annotation.PersonGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * 限定符注入注释演示
 *
 * @author 61404
 * @date 2021/11/17
 */
public class QualifierInjectionAnnotationDemo {

	@Autowired
	private Collection<Person> autoPersons;

	@Autowired
	@Qualifier
	private Collection<Person> qualifierPersons;

	@Autowired
	@PersonGroup
	private Collection<Person> cusQualifierPersons;

	@Bean
	@Qualifier
	public Person person1() {
		return Person.createPerson("person1");
	}

	@Bean
	@Qualifier
	public Person person2() {
		return Person.createPerson("person2");
	}

	@Bean
	@PersonGroup
	public Person person3() {
		return Person.createPerson("person3");
	}

	@Bean
	@PersonGroup
	public Person person4() {
		return Person.createPerson("person4");
	}

	public static void main(String[] args) {
		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 注册 Configuration Class（配置类）
		applicationContext.register(QualifierInjectionAnnotationDemo.class);

		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

		String xmlResourcePath = "classpath:/bean/bean.xml";
		// 加载 XML 资源，解析并且生成 BeanDefinition
		beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

		// 启动 Spring 应用上下文
		applicationContext.refresh();

		// 依赖查找并且创建 Bean
		QualifierInjectionAnnotationDemo bean = applicationContext.getBean(QualifierInjectionAnnotationDemo.class);
		System.out.println(bean.autoPersons);
		System.out.println(bean.qualifierPersons);
		System.out.println(bean.cusQualifierPersons);

		// 显示地关闭 Spring 应用上下文
		applicationContext.close();
	}
}
