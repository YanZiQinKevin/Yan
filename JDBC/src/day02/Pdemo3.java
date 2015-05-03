package day02;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Pdemo3 {
 public static void main(String[] args) 
 throws Exception{
	Connection conn = 
		Jdbc.getConnection();
	//演示数据库元数据
	DatabaseMetaData data = conn.getMetaData();
	//数据库名称
	System.out.println(
			data.getDatabaseProductName());
	//数据库版本名
	System.out.println(
			data.getDatabaseMajorVersion());
	//连接字符串
	System.out.println(data.getURL());
	//用户名
	System.out.println(data.getUserName());
	//System.out.println(data.getMaxRowSize()+":");
	
	
	//获取结果集元数据
	PreparedStatement stmt = null;
	stmt = conn.prepareStatement("SELECT * FROM t_user_tao");
	ResultSet rs = stmt.executeQuery();
	ResultSetMetaData rsmd = 
		 rs.getMetaData();
	
	System.out.println("====>");
	System.out.println(rsmd.getTableName(1));
	int count = rsmd.getColumnCount();
	for(int i=1;i<=count;i++){
		System.out.print(
				rsmd.getColumnName(i)+" ");
		
	}
	Jdbc.close(null, null, conn);
}
}
