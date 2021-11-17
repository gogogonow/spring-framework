package com.twei.beandefinition.po;

import org.springframework.core.io.Resource;

import java.util.Arrays;
import java.util.List;

/**
 * 人
 *
 * @author 61404
 * @date 2021/10/24
 */
public class Person {
	private String name;
	private Integer age;
	private City city;
	private City[] workCities;
	private List<City> lifeCities;
	private Resource configLocation;

	public static Person createPerson() {
		Person person = new Person();
		person.setAge(11);
		person.setName("Jack");
		return person;
	}

	public static Person createPerson(String name) {
		Person person = new Person();
		person.setAge(11);
		person.setName(name);
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Resource getConfigLocation() {
		return configLocation;
	}

	public void setConfigLocation(Resource configLocation) {
		this.configLocation = configLocation;
	}

	public City[] getWorkCities() {
		return workCities;
	}

	public void setWorkCities(City[] workCities) {
		this.workCities = workCities;
	}

	public List<City> getLifeCities() {
		return lifeCities;
	}

	public void setLifeCities(List<City> lifeCities) {
		this.lifeCities = lifeCities;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", city=" + city +
				", workCities=" + Arrays.toString(workCities) +
				", lifeCities=" + lifeCities +
				", configLocation=" + configLocation +
				'}';
	}
}
