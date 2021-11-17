package com.twei.dependencyInjection;

import com.twei.beandefinition.po.Person;
import com.twei.general.ioc.javabeans.PersonHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 注释setter注入演示
 *
 * @author 61404
 * @date 2021/11/17
 */
public class FieldInjectionAnnotationDemo {

	// autowire会忽略掉static的字段
//	@Autowired
//	private PersonHolder autoPersonHolder;

	@Resource(type = PersonHolder.class)
	private PersonHolder userHolder;

	public static void main(String[] args) {
		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 注册 Configuration Class（配置类）
		applicationContext.register(FieldInjectionAnnotationDemo.class);

		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

		String xmlResourcePath = "classpath:/bean/bean.xml";
		// 加载 XML 资源，解析并且生成 BeanDefinition
		beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

		// 启动 Spring 应用上下文
		applicationContext.refresh();

		FieldInjectionAnnotationDemo bean = applicationContext.getBean(FieldInjectionAnnotationDemo.class);
//		System.out.println(bean.autoPersonHolder);
		System.out.println(bean.userHolder);
//		System.out.println(bean.rsPersonHolder == bean.autoPersonHolder);

		// 显示地关闭 Spring 应用上下文
		applicationContext.close();
	}


	@Bean
	public PersonHolder userHolder(Person person) {
		return new PersonHolder(person);
	}
}
