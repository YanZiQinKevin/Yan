package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Jdbc {
  static{
	  try{
		  
		  Class.forName("com.mysql.jdbc.Driver");
	  }catch (Exception e) {
		// TODO: handle exception
	}
	  
	  
  }
  
	public static Connection getConnection(){
		String url="jdbc:mysql://127.0.0.1/test?userUnicode=true&characterEncoding=utf-8";
		String dbname="";
		String dbpwd="";
		try {
			return DriverManager.getConnection(url,dbname,dbpwd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		  return null;
	}
	
	
  public static void close(ResultSet rs,Statement stmt,Connection conn){
	  if(rs!=null){
		  try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  if(stmt!=null){
		  try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  if(conn!=null){
		  try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  } 
  public static void main(String[] args) {
	System.out.println(Jdbc.getConnection());
 }
}
