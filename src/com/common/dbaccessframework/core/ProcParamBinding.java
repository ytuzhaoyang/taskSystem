package com.common.dbaccessframework.core;

import java.sql.CallableStatement;
import java.sql.SQLException;


/**
 * @author ����
 * @version ����ʱ�䣺2010-10-11 ����04:49:36
 * @function 
 */
public interface ProcParamBinding{

	public void bindParam(CallableStatement pstmt) throws SQLException; 
}
