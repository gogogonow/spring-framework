package com.twei.beandefinition.po;

/**
 * 人
 *
 * @author 61404
 * @date 2021/10/24
 */
public class Person {
	private String name;
	private Integer age;

	public static Person createPerson() {
		Person person = new Person();
		person.setAge(11);
		person.setName("Jack");
		return person;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
