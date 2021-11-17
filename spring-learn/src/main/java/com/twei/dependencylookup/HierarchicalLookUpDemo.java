package com.twei.dependencylookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * bean提供者查找演示
 * Spring 5.1 Bean 延迟查找
 * @author 61404
 * @date 2021/11/13
 */
public class HierarchicalLookUpDemo {
	public static void main(String[] args) {
		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 将当前类 ObjectProviderDemo 作为配置类（Configuration Class）
		applicationContext.register(BeanProviderLookUpDemo.class);

		// 1. 获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
		ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
//        System.out.println("当前 BeanFactory 的 Parent BeanFactory ： " + beanFactory.getParentBeanFactory());

		// 2. 设置 Parent BeanFactory
		HierarchicalBeanFactory parentBeanFactory = createParentBeanFactory();
		beanFactory.setParentBeanFactory(parentBeanFactory);
//        System.out.println("当前 BeanFactory 的 Parent BeanFactory ： " + beanFactory.getParentBeanFactory());

		displayContainsLocalBean(beanFactory, "person");
		displayContainsLocalBean(parentBeanFactory, "person");

		displayContainsBean(beanFactory, "person");
		displayContainsBean(parentBeanFactory, "person");

		// 启动应用上下文
		applicationContext.refresh();

		// 关闭应用上下文
		applicationContext.close();

	}

	private static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName) {
		System.out.printf("当前 BeanFactory[%s] 是否包含 Bean[name : %s] : %s\n", beanFactory, beanName,
				containsBean(beanFactory, beanName));
	}

	private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
		BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
		if (parentBeanFactory instanceof HierarchicalBeanFactory) {
			HierarchicalBeanFactory parentHierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
			if (containsBean(parentHierarchicalBeanFactory, beanName)) {
				return true;
			}
		}
		return beanFactory.containsLocalBean(beanName);
	}

	private static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
		System.out.printf("当前 BeanFactory[%s] 是否包含 Local Bean[name : %s] : %s\n", beanFactory, beanName,
				beanFactory.containsLocalBean(beanName));
	}

	private static ConfigurableListableBeanFactory createParentBeanFactory() {
		// 创建 BeanFactory 容器
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		// XML 配置文件 ClassPath 路径
		String location = "classpath:/bean/bean.xml";
		// 加载配置
		reader.loadBeanDefinitions(location);
		return beanFactory;
	}
}
