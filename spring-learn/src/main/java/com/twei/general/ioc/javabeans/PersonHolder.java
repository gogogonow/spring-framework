package com.twei.general.ioc.javabeans;

import com.twei.beandefinition.po.Person;

/**
 * 人座
 *
 * @author 61404
 * @date 2021/11/17
 */
public class PersonHolder {
	private Person person;

	public PersonHolder(Person person) {
		this.person = person;
	}

	public PersonHolder() {
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "PersonHolder{" +
				"person=" + person +
				'}';
	}
}
