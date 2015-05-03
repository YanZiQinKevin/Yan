package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Pdemo2 {

	/**
	 * @param args
	 */  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start =System.currentTimeMillis(); 
		Connection conn=null;
         PreparedStatement stmt=null;
         try {
			conn=Jdbc.getConnection();
			//conn.setAutoCommit(false);
			
			String sql="insert into y_kevin values(?)";
			stmt=conn.prepareStatement(sql);
			for(int i=1;i<100000000;i++){
				stmt.setInt(1, i);
				stmt.executeUpdate();
			}
			
			
				//conn.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			Jdbc.close(null, stmt, conn);
		}
		long end =System.currentTimeMillis(); 
		System.out.println((end-start)/1000/60);
	}

}
