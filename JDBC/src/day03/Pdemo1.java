package day03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pdemo1 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
      Connection conn=null;
      Statement stmt=null;
        ResultSet rs=null;
      conn=DruidUtilsPro.getConnection();
      stmt=conn.createStatement();
       rs=stmt.executeQuery("select *from user_kevin");
          while (rs.next()) {
			   String name=rs.getString("name");
			   String pwd=rs.getString("pwd");
			   System.out.println(name+" "+pwd);
			
		}
       
       DruidUtilsPro.close(conn);
		
	}

}
