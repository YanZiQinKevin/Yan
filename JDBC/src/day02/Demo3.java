package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.codec.digest.DigestUtils;

public class Demo3 {

	public boolean login(String username, String password) {
		boolean bl=InjectCheck.inject_check(username);
		if(bl==true){
			return false;
		}
		bl=InjectCheck.inject_check(password);
		if(bl==true){
			return false;
		}
		password = DigestUtils.sha1Hex(password);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.1.42:1521:orcl", "s01", "s01");
			String sql = "select count(*) c from user_kevin where name=? and pwd=?";

			stmt = conn.prepareStatement(sql);
			System.out.println(username + " " + password);
			stmt.setString(1, username);
			stmt.setString(2, password);

			rs = stmt.executeQuery();

			while (rs.next()) {
				int r = rs.getInt("c");
				System.out.println(r);
				if (r > 0) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}

	public void createUser(int id,String username, String password, String address) {
		 boolean rs  = InjectCheck.inject_check(username);
		 if(rs == true){
			 return;
		 }
		 rs  = InjectCheck.inject_check(password);
		 if(rs == true){
			 return;
		 }
		 rs  = InjectCheck.inject_check(address);
		 if(rs == true){
			 return;
		 }

		 password = SecUtile.sha(password);
		
		Connection conn = Jdbc.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into user_kevin values(?,?,?,?)";
         try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, username);
			stmt.setString(3, password);
			stmt.setString(3, address);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Jdbc.close(null, stmt, conn);
		}
	}

	
	public void deleteUserById(int id){
		boolean rs=existsUserById(id);
		if(rs==false){
			return;
		}
		Connection conn = Jdbc.getConnection();
		PreparedStatement stmt = null;
		String sql="delect from user_kevin where id=?";
		 try {
				stmt=conn.prepareStatement(sql);
				stmt.setInt(1, id);
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				Jdbc.close(null, stmt, conn);
			}
	}
	
	public void updateUserPwd(String pwd ,int id){
		boolean rs=existsUserById(id);
		if(rs==false){
			return;
		}
		Connection conn = Jdbc.getConnection();
		PreparedStatement stmt = null;
		pwd=DigestUtils.sha1Hex(pwd);
		String sql="update user_kevin set pwd=? where id=?";
		  try {
				stmt=conn.prepareStatement(sql);      
				stmt.setString(1, pwd);
				stmt.setInt(2, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				Jdbc.close(null, stmt, conn);
			}
	}
	

	public boolean existsUserById(int id){
    	Connection conn = Jdbc.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
    	String sql="select count(*) c from user_kevin where id=?";
    	 try {
				stmt=conn.prepareStatement(sql);
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				while (rs.next()) {
					int r = rs.getInt("c");
					System.out.println(r);
					if (r > 0) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				Jdbc.close(rs, stmt, conn);
			}
    	return false;
    }
	
	
	public static void main(String[] args) {
		System.out.println(Jdbc.getConnection());
//		boolean rs = new Demo3().login("kevin1", "1001");
//		System.out.println(rs);
	}

}
