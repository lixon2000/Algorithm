package com.lx.db;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 用于获得MySQL的连接，利用Mybatis的连接池，可以获得Mybatis的Session和sql的connection

public class ConnectFactoryImpl implements ConnectionFactory {
	private static Logger logger = LoggerFactory.getLogger(ConnectFactoryImpl.class);
	
	private static ConnectFactoryImpl _instance;
	private ConnectFactoryImpl() {
	}
	public static ConnectFactoryImpl getInstance() {
		if (_instance != null) {
			return _instance;
		}else{
			synchronized (hasInit) {
				if (_instance == null) {
					_instance = new ConnectFactoryImpl();
					_instance.init("cfg/ConfigMapper.xml");
				}
				return _instance;
			}
		}
	}
	
	private SqlSessionFactory serverconfig_sqlSessionFactory = null;		// 框架配置数据库连接
	private SqlSessionFactory base_sqlSessionFactory = null;		// 业务配置数据库连接
	private SqlSessionFactory user_sqlSessionFactory = null;		// 用户信息数据库连接
	private QueryRunner run = new QueryRunner();
	
	private static AtomicBoolean hasInit = new AtomicBoolean(false);
	public boolean init(String config) {
		if(hasInit.get()) {
			return true;
		}
		else {
			synchronized (hasInit) {
				logger.info("db has been created!");

				File cfg = new File(config);
				if (cfg.exists()) {
					try {
						FileReader reader = new FileReader(cfg);
						SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
						serverconfig_sqlSessionFactory = sessionFactoryBuilder.build(reader,"st_serverconfig");
						
						// base 
						FileReader reader1 = new FileReader(cfg);
						base_sqlSessionFactory = sessionFactoryBuilder.build(reader1,"st_base");

						// user 
						Reader reader2 = new FileReader(cfg);
						user_sqlSessionFactory = sessionFactoryBuilder.build(reader2,"st_user");
						
						logger.info("load db config:{}", cfg);
						
						hasInit.set(true);
						return true;
					} catch (Throwable t) {
						logger.error("exception", t);
						return false;
					}
				} else {
					logger.error("cfg not exist!");
					return false;
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void addMapper(SqlSessionFactory ssf, Class cls)
	{
		if(!ssf.getConfiguration().hasMapper(cls)){
			ssf.getConfiguration().addMapper(cls);
		}
	}
	
	public <T> T getMapper(Class<T> type, SqlSession session) {
		if (session != null) {
			T t = session.getMapper(type);
			return t;
		} else {
			return null;
		}
	}
	
	public SqlSession getServerBaseSession() {
		SqlSession session = serverconfig_sqlSessionFactory.openSession(true);
		return session;
	}
	
	public SqlSession getBaseSession() {
		SqlSession session = base_sqlSessionFactory.openSession(true);
		return session;
	}

	public SqlSession getUserSession() {
		SqlSession session = user_sqlSessionFactory.openSession(true);
		return session;
	}
	
	public <T,M,E> List<T> getAll(Class<T> type, Class<M> mapClass, Class<E> exampleClass) throws IOException {
		SqlSession session = getBaseSession();
		List<T> dataList = new ArrayList<T>();
		try {
			M mapper = getMapper(mapClass, session);
			E ide = exampleClass.newInstance();
			Method selectMethod = mapClass.getDeclaredMethod("selectByExample", exampleClass);
			dataList = (List<T>) selectMethod.invoke(mapper, ide);
		}catch(Throwable t) {
			logger.error("exception", t);
		}finally{
			session.close();
		}
		
		return dataList;
	}
	
	public <T> List<T> loadObjects(String tableName, Class<T> cls){
		SqlSession session = getBaseSession();
//		session.select(statement,handler);
		Connection connection = session.getConnection();
		try {
			String sql = "select * from " + tableName; 
			ResultSetHandler<List<T>> h = new BeanListHandler<T>(cls);
			return run.query(connection, sql, h);
		}catch(Throwable t) {
			logger.debug("exception", t);
			return null;
		}finally {
			session.close();
			try
			{
				connection.close();
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// sql连接，用于从Mybatis的连接池中获得连接的Connection，用完后将其close
	
	// connection与session的对应表，关闭connection时，一定要将session关闭
	private Map conn2Sessions = Collections.synchronizedMap(new HashMap());
	
	@Override
	public synchronized Connection getConnection() {
		SqlSession session = getUserSession();
		conn2Sessions.put(session.getConnection(), session);
		return session.getConnection();
	}

	@Override
	public synchronized void closeConnect(Connection conn) {
		SqlSession session = (SqlSession) conn2Sessions.remove(conn);
		if(session != null){
			session.close();
		}else{
			logger.warn("SqlSession not found for conn:{}", conn);
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("exception", e);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
//		List<Itemequipconfig> list = ShopDBHelper.getInstance().getAll(Itemequipconfig.class, ItemequipconfigMapper.class, ItemequipconfigExample.class);
//		logger.warn("list:{}", list);
		ConnectFactoryImpl.getInstance().getUserSession().getConnection();
	}
}
