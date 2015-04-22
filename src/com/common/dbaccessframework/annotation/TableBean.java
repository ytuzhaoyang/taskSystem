package com.common.dbaccessframework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TableBean {

	/*表示该字段是否需要数据库中取值
	 * true:不需要注解
	 * false:需要注解
	 */
	boolean ignore() default false;
	/*若Bean对象中属性名与数据库中字段名不匹配时，
	 * 手动指定数据库中字段的名称
	 * 若果一样该属性可以不指定
	 */
	String fieldName() default "default";
}
