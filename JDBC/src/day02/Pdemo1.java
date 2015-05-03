package day02;

import java.sql.Connection;
import java.sql.Statement;

public class Pdemo1 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Connection conn=null;
          Statement stmt=null;
          try {
			conn=Jdbc.getConnection();
			conn.setAutoCommit(false);
			
			String sql1="update student_kevin set majorid=3 where sid=1";
			String sql2="update student_kevin set majorid=2 where sid=2";
			String sql3="update student_kevin set majorid=1 where sid=3";
			
			stmt=conn.createStatement();
			int rs1=stmt.executeUpdate(sql1);
			int rs2=stmt.executeUpdate(sql2);
			int rs3=stmt.executeUpdate(sql3);

			if(rs1==1&&rs2==1&&rs3==1){
				conn.commit();
				System.out.println("yes");
			}else {
				conn.rollback();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			Jdbc.close(null, stmt, conn);
		}
	}

}
