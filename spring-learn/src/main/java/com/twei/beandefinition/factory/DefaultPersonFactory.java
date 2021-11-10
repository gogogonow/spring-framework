package com.twei.beandefinition.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * defauly人工厂
 *
 * @author 61404
 * @date 2021/11/10
 */
public class DefaultPersonFactory implements PersonFactory, InitializingBean, DisposableBean {

	@PostConstruct
	public void initByPostConstruct() {
		System.out.println("DefaultPersonFactory 通过 PostConstruct 初始化中。。。");
	}

	@PreDestroy
	public void destroyByPreDestroy() {
		System.out.println("DefaultPersonFactory 通过 PreDestroy 销毁中。。。");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("DefaultPersonFactory 通过 afterPropertiesSet 初始化中。。。");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DefaultPersonFactory 通过 destroy 销毁中。。。");
	}

	public void initByCustom() {
		System.out.println("DefaultPersonFactory 通过 自定义 初始化中。。。");
	}

	public void destroyByCustom() {
		System.out.println("DefaultPersonFactory 通过 自定义 销毁中。。。");
	}
}
