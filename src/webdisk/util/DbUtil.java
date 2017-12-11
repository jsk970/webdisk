package webdisk.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
/**
 * DBCP数据库连接池工具类
 * @author 
 * 2017-10-20
 */
public class DbUtil {
	
	private static BasicDataSource dataSource = null;

	public static void init(){
		if (dataSource != null){
			try{
				dataSource.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			dataSource = null;
		}
		
		try {
			Properties p = new Properties();
			
			//硬编码
//			p.setProperty("driverClassName", "com.mysql.jdbc.Driver");
//			p.setProperty("url", "jdbc:mysql://localhost:3306/webdisk");
//			p.setProperty("username", "root");
//			p.setProperty("password", "123456");
//			p.setProperty("maxActive", "30");
//			p.setProperty("maxIdle", "10");
		
			p.load(DbUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			dataSource = (BasicDataSource)BasicDataSourceFactory.createDataSource(p);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource()
	{
		if(dataSource == null) {
			init();
		}
		return dataSource;
	}
	
	public static synchronized Connection getConnection() {
		Connection con = null;
		if(dataSource == null) {
			init();
		}
		if(dataSource!=null) {
			try {
				con = dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
}
