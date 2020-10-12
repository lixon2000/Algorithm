package com.lx.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class DBUtilsTest {
	
	public static TestBean query(String sql){
		SqlSession session = ConnectFactoryImpl.getInstance().getUserSession();
		try {
			Connection conn = session.getConnection();
			QueryRunner run = new QueryRunner();
			BeanHandler<TestBean> handler = new BeanHandler<TestBean>(TestBean.class);
			return run.query(conn, sql, handler);
		}catch(Throwable t) {
			System.out.println(t);
			return null;
		}finally {
			session.close();
		}
	}
	
	public static int insert(String sql, Object[] params){
		SqlSession session = ConnectFactoryImpl.getInstance().getUserSession();
		try {
			Connection conn = session.getConnection();
			QueryRunner run = new QueryRunner();
			ResultSetHandler<Integer> handler = new ResultSetHandler<Integer>(){
				@Override
				public Integer handle(ResultSet rs) throws SQLException {
					Integer cnt = 0;
					while (rs.next()) {
						cnt = rs.getInt(1);
						break;
					}
					return cnt;
				}
			};
			return run.insert(conn, sql, handler, params);
		}catch(Throwable t) {
			System.out.println(t);
			return 0;
		}finally {
			session.close();
		}
	}
	
	public static void initLog(String path) {
		String logPath = path;
		if (logPath == null) {
			logPath = "cfg/logback.xml";
		}
		LoggerContext context = (LoggerContext) LoggerFactory
				.getILoggerFactory();

		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(context);
			// Call context.reset() to clear any previous configuration, e.g.
			// default
			// configuration. For multi-step configuration, omit calling
			// context.reset().
			context.reset();
			configurator.doConfigure(logPath);
		} catch (JoranException je) {
			// StatusPrinter will handle this
			je.printStackTrace();
		}
		StatusPrinter.printInCaseOfErrorsOrWarnings(context);
	}
	
	public static void main(String [] args){
		initLog(null);
		ConnectFactoryImpl.getInstance().init("ConfigMapper.xml");
//		for(int i=0;i<10000; i++){
//			Object[] params = {i, "user"+i, i+UUID.randomUUID().toString(), i, 1000};
//			DBUtilsTest.insert("insert into test(id, name, pVar, pInt, country) values(?,?,?,?,?)", params);
//		}
		int now1 = (int) (System.currentTimeMillis()/1000);
		System.out.println("----- 根据主键找 -----");
		for(int i=0;i<10000; i++){
			TestBean b = DBUtilsTest.query("select * from test where id=6712");
//			System.out.println(b);
		}
		int now2 = (int) (System.currentTimeMillis()/1000);
		System.out.println(now2 - now1);
		
		System.out.println("----- 不根据主键找 -----");
		for(int i=0;i<10000; i++){
			TestBean b = DBUtilsTest.query("select * from test where name like 'user123%'");
//			System.out.println(b);
		}
		int now3 = (int) (System.currentTimeMillis()/1000);
		System.out.println(now3 - now2);
		
	}

}
