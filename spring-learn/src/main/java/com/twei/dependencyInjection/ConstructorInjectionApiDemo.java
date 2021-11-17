package com.twei.dependencyInjection;

import com.twei.general.ioc.javabeans.PersonHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * api setter注入演示
 *
 * @author 61404
 * @date 2021/11/17
 */
public class ConstructorInjectionApiDemo {
	public static void main(String[] args) {

		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		// 生成 UserHolder 的 BeanDefinition
		BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
		// 注册 UserHolder 的 BeanDefinition
		applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

		String xmlResourcePath = "classpath:/bean/bean.xml";
		// 加载 XML 资源，解析并且生成 BeanDefinition
		beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

		// 启动 Spring 应用上下文
		applicationContext.refresh();

		// 依赖查找并且创建 Bean
		PersonHolder personHolder = applicationContext.getBean(PersonHolder.class);
		System.out.println(personHolder);

		// 显示地关闭 Spring 应用上下文
		applicationContext.close();
	}

	/**
	 * 创建用户持有人bean定义
	 * 为 {@link PersonHolder} 生成 {@link BeanDefinition}
	 *
	 * @return {@link BeanDefinition}
	 */
	private static BeanDefinition createUserHolderBeanDefinition() {
		BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(PersonHolder.class);
		definitionBuilder.addConstructorArgReference("person");
		return definitionBuilder.getBeanDefinition();
	}
}
