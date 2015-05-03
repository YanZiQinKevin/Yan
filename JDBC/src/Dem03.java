import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Dem03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Connection conn=null;
            Statement stmt=null;
            ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.42:1521:orcl", "s01", "s01");
			stmt=conn.createStatement();
		 rs=stmt.executeQuery("select *from dept_kevin");
			while(rs.next()){
			int deptno=rs.getInt("deptno");
			int ideptno=rs.getInt(1);
			System.out.println(deptno+":"+ideptno);
			String dname=rs.getString("dname");
			String loc=rs.getString("location");
			System.out.println(dname+":"+loc);
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
