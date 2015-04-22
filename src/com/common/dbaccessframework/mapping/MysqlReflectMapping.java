package com.common.dbaccessframework.mapping;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.common.dbaccessframework.annotation.TableBean;
import com.common.dbaccessframework.util.StringTool;


public class MysqlReflectMapping<T> implements IRowMapper<T>{
	// 与结果集相对应的对象类型
	private Class<T> beanClass;

	public MysqlReflectMapping(Class<T> beanClass) {
		super();
		this.beanClass = beanClass;
	}

	// 利用反射调用bean的set方法，给属性赋值
	private void setBeanValues(Object obj, ResultSet rs) throws SQLException {
		Method[] methods = obj.getClass().getDeclaredMethods();
		for (Method m : methods) {
			String methodName = m.getName();// 获取方法名
			if (methodName.startsWith("set")
					&& m.getParameterTypes().length == 1) {
				if (methodName.startsWith("set")
						&& m.getParameterTypes().length == 1) {
					TableBean table=m.getAnnotation(TableBean.class);
					String fieldName=null;
					if(table==null){
						//没有添加注解，直接反射取数据库中数据
						fieldName = StringTool.removeSet(methodName);// 获取对应的属性名
						try {
							if (m.getParameterTypes()[0].getName().equals(
							"java.sql.Date"))
								m.invoke(obj, rs.getDate(fieldName));// 使用反射，执行set方法，给bean的属性设定值
							else if(m.getParameterTypes()[0].getName().equals(
								"int"))
								m.invoke(obj, rs.getInt(fieldName));// 使用反射，执行set方法，给bean的属性设定值
							else if(m.getParameterTypes()[0].getName().equals(
								"long"))
								m.invoke(obj, rs.getLong(fieldName));// 使用反射，执行set方法，给bean的属性设定值
							else if(m.getParameterTypes()[0].getName().equals(
								"double"))
								m.invoke(obj, rs.getDouble(fieldName));// 使用反射，执行set方法，给bean的属性设定值
							else if(m.getParameterTypes()[0].getName().equals(
									"float"))
									m.invoke(obj, rs.getFloat(fieldName));// 使用反射，执行set方法，给bean的属性设定值
							else
								m.invoke(obj, rs.getString(fieldName));// 使用反射，执行set方法，给bean的属性设定值
							} catch (Exception e) {
								System.out.println("字段[fieldName]数据类型:"+rs.getObject(fieldName).getClass().getName()+",错误:"+e.getMessage());
							}
						}else{
						//有注解的时候
						boolean flag=table.ignore();
						fieldName=table.fieldName();
						if(!flag){
							//该属性需要封装到到bean对象中
							if("default".equals(fieldName)){
								//不需要修改获取的属性名称
								fieldName = StringTool.removeSet(methodName);// 获取对应的属性名
							}					
							try {
								if (m.getParameterTypes()[0].getName().equals(
									"java.sql.Date"))
									m.invoke(obj, rs.getDate(fieldName));// 使用反射，执行set方法，给bean的属性设定值
								else if(m.getParameterTypes()[0].getName().equals(
									"int"))
									m.invoke(obj, rs.getInt(fieldName));// 使用反射，执行set方法，给bean的属性设定值
								else if(m.getParameterTypes()[0].getName().equals(
									"long"))
									m.invoke(obj, rs.getLong(fieldName));// 使用反射，执行set方法，给bean的属性设定值
								else if(m.getParameterTypes()[0].getName().equals(
									"double"))
									m.invoke(obj, rs.getDouble(fieldName));// 使用反射，执行set方法，给bean的属性设定值
								else
									m.invoke(obj, rs.getString(fieldName));// 使用反射，执行set方法，给bean的属性设定值
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	public T mappingRow(ResultSet rs) throws SQLException {
		T obj=null;
		try {
			obj = this.beanClass.newInstance();
			this.setBeanValues(obj, rs);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
