package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.COMM_FAILURE;

public class Demo1 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Connection conn=null;
       
        Statement stmt=null;
        ResultSet rs=null;
        
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.42:1521:orcl", "s01", "s01");
            stmt=conn.createStatement();
          rs=  stmt.executeQuery("select *from dept_kevin");
			while(rs.next()){
				Dep dep=new Dep();
				dep.setDeptno(rs.getInt("deptno"));
				dep.setDname(rs.getString("dname"));
				dep.setLocation(rs.getString("location"));
			}
          
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
