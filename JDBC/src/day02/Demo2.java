package day02;

import java.awt.RadialGradientPaint;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.And;

import sun.security.jgss.LoginConfigImpl;

public class Demo2 {
	public static List<User> list = new ArrayList<User>();
	String choose;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo2 d = new Demo2();
		d.login("miss", "123");

	}

	public static List<User> jdbc(String choose) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.1.42:1521:orcl", "s01", "s01");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(choose);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setAddress(rs.getString("address"));
				list.add(user);
			}
			System.out.println(list);
			return list;

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
		return null;
	}

	public boolean login(String username, String password) {
		String sql = "select * from user_kevin where";
		sql+=" name='"+username+"'and pwd='"+password+"'"; 
		

		if(jdbc(sql).size()==1){
			System.out.println("true");
			return true;
			
		}

		return false;
	}

	

}
