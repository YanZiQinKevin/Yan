package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pdemo2 {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
         Connection conn=DruidUtilsPro.getConnection();
         String sql="insert into t_user(name)values('kk')";
          PreparedStatement stmt=null;
          stmt=conn.prepareStatement(sql,new String[]{});
          stmt.executeUpdate();
          ResultSet rs=stmt.getGeneratedKeys();
          if(rs.next()){
        	  System.out.println(rs.next());
          }
          DruidUtilsPro.close(stmt);
          DruidUtilsPro.close(rs);
          DruidUtilsPro.close(conn);
          
	}

}
