package com.twei.general.ioc.javabeans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * bean信息演示
 *
 * @author 61404
 * @date 2021/10/28
 */
public class BeanInfoDemo {
	public static void main(String[] args) throws IntrospectionException {
		// Object.class 为 查找stopClass
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
		Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {

			System.out.println(propertyDescriptor);

			// 使用PropertyEditor转换属性类型
			propertyDescriptor.setPropertyEditorClass(IntegerToStringEditor.class);
		});
	}

	static class IntegerToStringEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			Integer value = Integer.valueOf(text);
			setValue(value);
		}
	}
}
