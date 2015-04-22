package com.common.dbaccessframework.util;

public class StringTool {
	// 首字母改大写
	public static String parseFirstUpperCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	// 首字母改小写
	public static String parseFirstLowerCase(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	// 根据get方法，得到属性名
	public static String removeGet(String methodName) {
		if (!methodName.startsWith("get"))
			return methodName;
		return StringTool.parseFirstLowerCase(methodName.substring(3));
	}

	// 根据set方法，得到属性名
	public static String removeSet(String methodName) {
		if (!methodName.startsWith("set"))
			return methodName;
		return StringTool.parseFirstLowerCase(methodName.substring(3));
	}

	// 根据属性名，得到对应的get方法方法名
	public static String addGet(String fieldName) {
		return "get" + StringTool.parseFirstUpperCase(fieldName);
	}

	// 根据属性名，得到对应的set方法方法名
	public static String addSet(String fieldName) {
		return "set" + StringTool.parseFirstUpperCase(fieldName);
	}

}
