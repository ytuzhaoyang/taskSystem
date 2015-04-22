package com.common.dbaccessframework.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.common.dbaccessframework.exception.DataBaseException;
import com.common.dbaccessframework.mapping.IRowMapper;
import com.common.dbaccessframework.util.PageModel;


public class BaseDAO<T>{
	
	protected DBConnection dbConn=new DBConnection();
	private Logger logs = Logger.getLogger(BaseDAO.class);
	/**
	 * 执行增、删、改等操作，不返回结果集 
	 * @param sql ： 
	 * @return 影响记录的行数
	 */
	public int updateBySql(String sql){
		Connection conn = null;
		Statement stmt = null;  
		try {
			conn = dbConn.getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DataBaseException(e.getMessage());
		}finally{
			dbConn.closeStatment(stmt);
			dbConn.closeConnection(conn);
		}
	}
	
	protected void del(String sql,String keyName,final String values)
	{
		//sql="delete from dift_net_mt where 1=1 and "+keyName+" in (?)";
		StringBuffer sb=new StringBuffer();
		sb.append(sql).append(keyName).append(" in ("+values+")");
		updateBySql(sb.toString());
	}
	
	/**
	 * 执行增、删、改等操作，不返回结果集
	 * @param sql
	 * @param bind
	 * @return 影响的行数
	 */
	public int updateBySql(String sql, IParamBinding bind){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			bind.bindParam(pstmt); //参数绑定
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			logs.error(sql,e);
			throw new DataBaseException(e.getMessage());
		}finally{
			dbConn.closeStatment(pstmt);
			dbConn.closeConnection(conn);
		}
		
	}
	/**
	 * 查询
	 */
	public List<T> queryBySql(String sql, IRowMapper<T> mapper){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<T> retList = new ArrayList<T>();
		try {
			conn = dbConn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				T obj = mapper.mappingRow(rs);
				retList.add(obj);
			}
		} catch (SQLException e) {
			logs.error(e);
			throw new DataBaseException(e.getMessage());
		}finally{
			dbConn.closeResultSet(rs);
			dbConn.closeStatment(stmt);
			dbConn.closeConnection(conn);
		}
		return retList;
	}

	public List<T> queryBySql(String sql, IParamBinding bind, IRowMapper<T> mapper){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> retList = new ArrayList<T>();
		try {
			conn = dbConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			bind.bindParam(pstmt); //参数绑定
			rs = pstmt.executeQuery();
			while(rs.next()){
				T obj = mapper.mappingRow(rs);
				retList.add(obj);
			}
		} catch (SQLException e) {
			throw new DataBaseException(e.getMessage());
		}finally{
			dbConn.closeResultSet(rs);
			dbConn.closeStatment(pstmt);
			dbConn.closeConnection(conn);
		}
		return retList;
	}

	public PageModel<T> split(String sql_list,String sql_count,int curpage,int pagesize,IParamBinding bind, IRowMapper<T> mapper){
		PageModel<T> page=new PageModel<T>();
		List<T> list=this.getList(sql_list, curpage, pagesize, bind, mapper);
		int count=this.getCount(sql_count, bind);
		page.setReList(list);
		page.setCurPage(curpage);
		page.setPageSize(pagesize);
		page.setItemCount(count);
		int totlePage=getPageNum(count,pagesize);
		page.setTotlePage(totlePage);
		page.setNextIndex(getNextPage(totlePage,curpage));
		page.setPerIndex(getPerPage(totlePage, curpage));
		return page;
	}
	
	public PageModel<T> split(String sql_list,String sql_count,int curpage,int pagesize, IRowMapper<T> mapper){
		PageModel<T> page=new PageModel<T>();
		List<T> list=this.getList(sql_list, curpage, pagesize, mapper);
		int count=this.getCount(sql_count);
		page.setReList(list);
		page.setCurPage(curpage);
		page.setPageSize(pagesize);
		page.setItemCount(count);
		int totlePage=getPageNum(count,pagesize);
		page.setTotlePage(totlePage);
		page.setNextIndex(getNextPage(totlePage,curpage));
		page.setPerIndex(getPerPage(totlePage, curpage));
		return page;
	}
	
	private List<T> getList(String sql_list,int curpage,int pagesize,IParamBinding bind, IRowMapper<T> mapper){
		String sql=sql_list+" limit "+(curpage-1)*pagesize+","+pagesize;
		return this.queryBySql(sql, bind, mapper);
	}
	
	private List<T> getList(String sql_list,int curpage,int pagesize, IRowMapper<T> mapper){
		String sql=sql_list+" limit "+(curpage-1)*pagesize+","+pagesize;
		return this.queryBySql(sql, mapper);
	}
	
	private int getPageNum(int count,int pagesize){
		int num=count%pagesize;
		if(count==0){
			return 1;
		}else if(num==0){
			return count/pagesize;
		}else{
			return count/pagesize+1;
		}
	}
	
	private int getNextPage(int pageNum,int curpage){
		if(curpage==pageNum){
			return -1;
		}else{
			return curpage+1;
		}
	}
	
	private int getPerPage(int pageNum,int curpage){
		if(curpage==1){
			return -1;
		}else{
			return curpage-1;
		}
	}
	
	private int getCount(String sql_count,IParamBinding bind){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count=0;
		try {
			conn = dbConn.getConnection();
			pstmt = conn.prepareStatement(sql_count);
			bind.bindParam(pstmt); //参数绑定
			rs = pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new DataBaseException(e.getMessage());
		}finally{
			dbConn.closeResultSet(rs);
			dbConn.closeStatment(pstmt);
			dbConn.closeConnection(conn);
		}
		return count;
	}
	
	private int getCount(String sql_count){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count=0;
		try {
			conn = dbConn.getConnection();
			pstmt = conn.prepareStatement(sql_count);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new DataBaseException(e.getMessage());
		}finally{
			dbConn.closeResultSet(rs);
			dbConn.closeStatment(pstmt);
			dbConn.closeConnection(conn);
		}
		return count;
	}
	//带有事务处理的SQL语句群
	/**
	 * 执行多条不带参数的SQL语句
	 * @param sqls
	 * @return
	 */
	public boolean executeBatch(String[] sqls){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = dbConn.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			for(int i=0; i<sqls.length; i++){
				stmt.addBatch(sqls[i]);
			}
			stmt.executeBatch();
			return true;
		} catch (SQLException e) {
			dbConn.rollbackTrans(conn);
			logs.error(e);
			return false;
		}finally{
			dbConn.commitTrans(conn);
			dbConn.closeStatment(stmt);
			dbConn.closeConnection(conn);
		}
	}
	

}
