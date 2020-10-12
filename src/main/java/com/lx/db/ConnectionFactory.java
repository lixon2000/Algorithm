package com.lx.db;

import java.sql.Connection;

public interface ConnectionFactory {
	public Connection getConnection();
	public void closeConnect(Connection conn);
}
