package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserManager {
	public static void main(String[] args)
	throws Exception{
//		boolean rs = new Pdemo1().login("tom", "123");
//		System.out.println(rs);
//		rs = new Pdemo1().login("' or 1=1 --", "123");
//		System.out.println(rs);
		//new Pdemo1().createUser("kk", "123", "s");
		
		//new Pdemo1().deleteUserById(1);
		//new Pdemo1().deleteUserById(11);
		//new Pdemo1().updateUserPwd(2, "222");
		
	}
	
	
 public boolean login(String username,String password)
 throws Exception{
	  boolean rs1 = InjectCheck.inject_check(username);
	  if(rs1==true){
		  return false;
	  }
	  rs1 = InjectCheck.inject_check(password);
	  if(rs1 == true){
		  return false;
	  }
	  
	  //转换
	  username = SecUtile.sha(username);
	  password = SecUtile.sha(password);
	  
	  
	  //----------------------
	  //看有什么不同点
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  
	  String url = "jdbc:oracle:thin:@192.168.1.42:1521:orcl";
	  Connection conn = 
		  DriverManager.getConnection(url, "s01","s01");
	  String sql = "SELECT count(*) as c FROM t_user_tao WHERE name = ? and pwd = ?";
	  PreparedStatement stmt = null;
	  //创建SQL语句对象->提前创建SQL
	  stmt = conn.prepareStatement(sql);
	  //绑定参数
	  stmt.setString(1, username);
	  stmt.setString(2, password);
	  
	  ResultSet rs = stmt.executeQuery();
	  while(rs.next()){
		  int r = rs.getInt("c");
		  if(r > 0){
			  return true;
		  }
	  }
	  rs.close();
	  stmt.close();
	  conn.close();
	  
	  return false;
	 
 }
 public void createUser(String username,
		   String password,String address)
 throws Exception{
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
   //1:加载驱动
	 username = SecUtile.sha(username);
	 password = SecUtile.sha(password);
   //2:获取连接
	Connection conn = 
		Jdbc.getConnection();
   //3:创建SQL
	PreparedStatement stmt = null;
	String sql = "INSERT INTO t_user_tao" +
			" VALUES(t_user_tao_se.nextval,?,?,?)";
	stmt = conn.prepareStatement(sql);
	stmt.setString(1, username);
	stmt.setString(2, password);
	stmt.setString(3, address);
   //4:执行
	stmt.executeUpdate();
   //5:关闭
	Jdbc.close(null, stmt, conn); 
 }
 
 
 
 
 public void deleteUserById(int id)
 throws Exception{
	boolean rs =  existsUserById(id);
	if(rs == false){
		return;
	}
	String sql = "DELETE FROM t_user_tao WHERE id = ?";
	 Connection conn = 
			Jdbc.getConnection();
	   //3:创建SQL
		PreparedStatement stmt = null;
		  stmt = conn.prepareStatement(sql);
	    stmt.setInt(1, id);
		stmt.executeUpdate();
     Jdbc.close(null, stmt, conn);		
 }
 //true  存在用户
 //false 不存在用户
 public boolean existsUserById(int id)
 throws Exception{
	 Connection conn = 
			Jdbc.getConnection();
	   //3:创建SQL
		PreparedStatement stmt = null;
		String sql = "SELECT count(*) as c FROM t_user_tao WHERE id = ?";
	    stmt = conn.prepareStatement(sql);
	    stmt.setInt(1, id);
		boolean exists = false;
	    //4:执行
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			int c = rs.getInt("c");
			if(c == 1){
				exists = true;
			}
		}
	   //5:关闭
		Jdbc.close(null, stmt, conn); 
		return exists;
 }
 
 
 
 //
 public void updateUserPwd(int id,String pwd)
 throws Exception{
	pwd = SecUtile.sha(pwd);
	boolean rs =  existsUserById(id);
	if(rs == false){
		return;
	}
	String sql = "UPDATE t_user_tao SET pwd = ? WHERE id = ?";
	 Connection conn = 
			Jdbc.getConnection();
	   //3:创建SQL
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, pwd);
	    stmt.setInt(2, id);
		stmt.executeUpdate();
     Jdbc.close(null, stmt, conn);		
 }
 
}
