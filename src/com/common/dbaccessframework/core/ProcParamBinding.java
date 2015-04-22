package com.common.dbaccessframework.core;

import java.sql.CallableStatement;
import java.sql.SQLException;


/**
 * @author 张玉
 * @version 创建时间：2010-10-11 上午04:49:36
 * @function 
 */
public interface ProcParamBinding{

	public void bindParam(CallableStatement pstmt) throws SQLException; 
}
