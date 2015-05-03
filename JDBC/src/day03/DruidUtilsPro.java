package day03;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtilsPro {

	public static String confile = "druid.properties";
	public static Properties p = null;
	private static DataSource ds = null;

	static {
		p = new Properties();
		InputStream inputStream = null;
		try {
			confile = DruidUtilsPro.class.getClassLoader().getResource("")
					.getPath()
					+ confile;
			System.out.println(confile);
			File file = new File(confile);
			inputStream = new BufferedInputStream(new FileInputStream(file));
			p.load(inputStream);
			initDataSource();//
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
    **初始化连接池
	 */
	public static final void initDataSource()
			 {
		DataSource dataSource = null;

		try {
			dataSource = DruidDataSourceFactory.createDataSource(p);
			ds =  dataSource;
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	
	/**
	 * 获取一个连接
	 * @return
	 */
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 关增连接
	 * @param conn
	 */
	public static void close(Connection conn){
	    if(conn != null){
	    	try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }	
	}
	
	public static void close(Statement stmt){
	    if(stmt != null){
	    	try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }	
	}	
	
	public static void close(ResultSet rs){
	    if(rs != null){
	    	try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }	
	}		
}
