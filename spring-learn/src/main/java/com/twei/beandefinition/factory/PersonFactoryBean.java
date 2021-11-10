package com.twei.beandefinition.factory;

import com.twei.beandefinition.po.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * 人工厂bean
 *
 * @author 61404
 * @date 2021/11/10
 */
public class PersonFactoryBean implements FactoryBean<Person> {
	@Override
	public Person getObject() throws Exception {
		return Person.createPerson();
	}

	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}
}
