package com.zy.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.common.dbaccessframework.core.BaseDAO;
import com.common.dbaccessframework.core.IParamBinding;
import com.common.dbaccessframework.mapping.MysqlReflectMapping;
import com.common.dbaccessframework.util.PageModel;
import com.zy.po.ManagerBean;

public class ManagerDao extends BaseDAO<ManagerBean>{

	public ManagerBean login(final String name,final String password){
		String sql = "select * from tbl_manager where managerName=? and managerPwd=? and managerState=0 ";
		List<ManagerBean> managers = super.queryBySql(sql, new IParamBinding() {
			
			public void bindParam(PreparedStatement pstmt) throws SQLException {
                   pstmt.setString(1, name);
                   pstmt.setString(2, password);
			}
		}, new MysqlReflectMapping<ManagerBean>(ManagerBean.class));
		System.out.println(managers.size());
		return managers.size()==0?null:managers.get(0);
		
	}
	
	public PageModel<ManagerBean> all(int curpage,int pagesize){
		String sql_list="select * from tbl_manager where managerState=0";
		String sql_count="select count(*) from tbl_manager where managerState=0";
		return super.split(sql_list, sql_count, curpage, pagesize, new MysqlReflectMapping<ManagerBean>(ManagerBean.class));
	}
	
	public void add(final ManagerBean bean){
		String sql = "insert into tbl_manager(managerName,managerPhone,managerPwd,managerState) values(?,?,?,?)";
	    super.updateBySql(sql, new IParamBinding() {
			public void bindParam(PreparedStatement pstmt) throws SQLException {
         	      	pstmt.setString(1, bean.getManagerName());
         	      	pstmt.setString(2, bean.getManagerPhone());
         	      	pstmt.setString(3, bean.getManagerPwd());
         	      	pstmt.setInt(4, bean.getManagerState());
			}
		});
	}
	
	public void del(int id){
		String sql = "update tbl_manager set managerState=-1 where managerId="+id;
		super.updateBySql(sql);
	}
	
}
