package com.common.dbaccessframework.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	static{
		try{
			//mysql连接方式
			//Class.forName("com.mysql.jdbc.Driver");
			//使用连接池的形式
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
        }catch(Exception ex){
            ex.printStackTrace();
        }
	}
	
	public  Connection getConnection(){
		//String url="jdbc:mysql://218.201.134.109:3306/mas?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false";
		//String url="jdbc:mysql://127.0.0.1:3306/mas?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false";
		try{
            return DriverManager.getConnection("proxool.Develop");
			//return DriverManager.getConnection(url, "root", "zy931017");
			//return DriverManager.getConnection(url, "root", "");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public void closeConnection(Connection conn){
		try {
			if(conn != null){
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭执行SQL语句的对象Statement
	 * @param stmt
	 */
	public void closeStatment(Statement stmt){
		try {
			if(stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭结果集
	 * @param rs
	 */
	public void closeResultSet(ResultSet rs){
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs=null;
	}
	
	public void commitTrans(Connection conn){
		try {
			if(conn != null)
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rollbackTrans(Connection conn){
		try {
			if(conn != null)
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
