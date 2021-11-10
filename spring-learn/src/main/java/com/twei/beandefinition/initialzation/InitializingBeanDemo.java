package com.twei.beandefinition.initialzation;

import com.twei.beandefinition.factory.DefaultPersonFactory;
import com.twei.beandefinition.factory.PersonFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * 初始化bean演示
 *
 * @author 61404
 * @date 2021/11/10
 */
@Configuration
public class InitializingBeanDemo {
	public static void main(String[] args) {
		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 注册 Configuration Class（配置类）
		applicationContext.register(InitializingBeanDemo.class);
		// 启动 Spring 应用上下文
		applicationContext.refresh();
		// 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
		System.out.println("Spring 应用上下文已启动...");
		// 依赖查找 PersonFactory
		PersonFactory personFactory = applicationContext.getBean(PersonFactory.class);
		System.out.println(personFactory);
		System.out.println("Spring 应用上下文准备关闭...");
		// 关闭 Spring 应用上下文
		applicationContext.close();
		System.out.println("Spring 应用上下文已关闭...");
	}

	@Bean(destroyMethod = "destroyByCustom", initMethod = "initByCustom")
	@Lazy(false)
	public DefaultPersonFactory createPersonFactory() {
		return new DefaultPersonFactory();
	}
}
