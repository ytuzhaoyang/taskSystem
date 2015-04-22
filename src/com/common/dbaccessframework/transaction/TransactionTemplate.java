package com.common.dbaccessframework.transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.*;

import com.common.dbaccessframework.core.DBConnection;

public class TransactionTemplate implements InvocationHandler {

	//要代理的原始对象
	private Object objOriginal;
	
	/*
	 * 构造函数
	 */
	public TransactionTemplate(Object objOriginal) {
		this.objOriginal = objOriginal;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result=null;
		DBConnection dbCon=new DBConnection();
		Connection con=dbCon.getConnection();
		con.setAutoCommit(false);
		Class[] parms=new Class[1]; 
		parms[0]=java.sql.Connection.class;
		try{
			Method setMethod=this.objOriginal.getClass().getMethod("setCon",parms);
			//Method[] mmm=this.objOriginal.getClass().getMethods();
//			for(int i=0;i<mmm.length;i++){
//				System.out.println(mmm[i]);
//			}
			setMethod.invoke(this.objOriginal,con);
			result=method.invoke(this.objOriginal, args);
			con.commit();
		}catch(Exception ex){
			//ex.printStackTrace();
			con.rollback();
		}finally{
			dbCon.closeConnection(con);
		}
		return result;
	}

}
