package com.twei.beandefinition.factory;

import com.twei.beandefinition.po.Person;
import com.twei.general.ioc.javabeans.User;

/**
 * 人的工厂
 *
 * @author 61404
 * @date 2021/11/10
 */
public interface PersonFactory {
	/**
	 * 创造人
	 *
	 * @return {@link Person}
	 */
	default Person createPerson() {
		return Person.createPerson();
	}
}
