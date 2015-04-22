package com.common.dbaccessframework.core;

import java.sql.CallableStatement;
import java.sql.SQLException;

public interface ProRowMapper<T>{

	public T mappingRow(CallableStatement cs) throws SQLException;
}
