package com.common.dbaccessframework.util;

public class StringTool {
	// ����ĸ�Ĵ�д
	public static String parseFirstUpperCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	// ����ĸ��Сд
	public static String parseFirstLowerCase(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	// ����get�������õ�������
	public static String removeGet(String methodName) {
		if (!methodName.startsWith("get"))
			return methodName;
		return StringTool.parseFirstLowerCase(methodName.substring(3));
	}

	// ����set�������õ�������
	public static String removeSet(String methodName) {
		if (!methodName.startsWith("set"))
			return methodName;
		return StringTool.parseFirstLowerCase(methodName.substring(3));
	}

	// �������������õ���Ӧ��get����������
	public static String addGet(String fieldName) {
		return "get" + StringTool.parseFirstUpperCase(fieldName);
	}

	// �������������õ���Ӧ��set����������
	public static String addSet(String fieldName) {
		return "set" + StringTool.parseFirstUpperCase(fieldName);
	}

}
