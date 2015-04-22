package com.common.dbaccessframework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TableBean {

	/*��ʾ���ֶ��Ƿ���Ҫ���ݿ���ȡֵ
	 * true:����Ҫע��
	 * false:��Ҫע��
	 */
	boolean ignore() default false;
	/*��Bean�����������������ݿ����ֶ�����ƥ��ʱ��
	 * �ֶ�ָ�����ݿ����ֶε�����
	 * ����һ�������Կ��Բ�ָ��
	 */
	String fieldName() default "default";
}
