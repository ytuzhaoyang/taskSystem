package com.common.dbaccessframework.mapping;

import java.sql.CallableStatement;
import java.sql.SQLException;

public interface ProcMapper {

	public Object[] mappingRow(CallableStatement cs) throws SQLException;
}
