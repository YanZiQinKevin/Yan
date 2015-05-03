import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.border.EmptyBorder;


public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		List<Emp> list=new ArrayList<Emp>();
          Connection conn=null;
            Statement stmt=null;
            ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.42:1521:orcl", "s01", "s01");
			stmt=conn.createStatement();
		 rs=stmt.executeQuery("select *from emp_kevin where sal>1200");
			System.out.println("编号 姓名 工作");
		 while(rs.next()){
              Emp emp=new Emp();
               emp.setEmpno(rs.getInt("empno"));
			       emp.setEname(rs.getString("ename"));
			       emp.setJob(rs.getString("job"));
			       
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
