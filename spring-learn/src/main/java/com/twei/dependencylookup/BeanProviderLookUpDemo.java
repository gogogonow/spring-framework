package com.twei.dependencylookup;

import com.twei.beandefinition.po.Person;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.GenericApplicationContext;

/**
 * bean提供者查找演示
 * Spring 5.1 Bean 延迟查找
 * @author 61404
 * @date 2021/11/13
 */
public class BeanProviderLookUpDemo {
	public static void main(String[] args) {
		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 将当前类 ObjectProviderDemo 作为配置类（Configuration Class）
		applicationContext.register(BeanProviderLookUpDemo.class);
		// 启动应用上下文
		applicationContext.refresh();
		// 依赖查找集合对象
		lookupByObjectProvider(applicationContext);
		lookupIfAvailable(applicationContext);
		lookupByStreamOps(applicationContext);

		// 关闭应用上下文
		applicationContext.close();

	}

	private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
//        Iterable<String> stringIterable = objectProvider;
//        for (String string : stringIterable) {
//            System.out.println(string);
//        }
		// Stream -> Method reference
		objectProvider.stream().forEach(System.out::println);
	}

	private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<Person> userObjectProvider = applicationContext.getBeanProvider(Person.class);
		Person person = userObjectProvider.getIfAvailable(Person::createPerson);
		System.out.println("当前 User 对象：" + person);
	}

	@Bean
	@Primary
	public String helloWorld() { // 方法名就是 Bean 名称 = "helloWorld"
		return "Hello,World";
	}

	@Bean
	public String message() {
		return "Message";
	}

	private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
		System.out.println(objectProvider.getObject());
	}
}
