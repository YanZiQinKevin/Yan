package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import day02.Jdbc;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
                 test();
	}
	
	public static void page(int pagNO,int pagSize) throws Exception {
		Connection conn=Jdbc.getConnection();
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=stmt.executeQuery("select *from t_emp_kevin");
	    int begin=(pagNO-1)*pagSize+1;
		 rs.absolute(begin);
		 for(int i=0;i<pagSize;i++){
			 System.out.println(rs.getInt("empno"));
			 if(!rs.next()){
				 break;
			 }
			 
		 }
		
		Jdbc.close(rs, stmt, conn);
	}
	public static void getpage(int pageNo,int pageSize) throws Exception {
		// TODO Auto-generated method stub
         Connection conn=null;
         PreparedStatement stmt=null;
          ResultSet rs=null;
          conn=Jdbc.getConnection();
          String sql="select empno,ename";
          sql+=" from (select rownum rn,empno,ename)";
          sql+=" from t_emp_kevin";
          sql+=" where rn between ? and ?";
          
          int begin=(pageNo-1)*pageSize+1;
          int end=begin+pageSize-1;
          stmt=conn.prepareStatement(sql);
          stmt.setInt(1, begin);
            stmt.setInt(2, end);
            rs=stmt.executeQuery();
            while (rs.next()) {
				System.out.println(rs.getInt("empno"));
			}
          
          Jdbc.close(rs, stmt, conn);   
		
	}
	
public static void  test() throws SQLException {
	Connection conn=Jdbc.getConnection();
	Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY);
	ResultSet rs=stmt.executeQuery("select *from t_emp_kevin");
	
	rs.next();
	System.out.println(rs.getInt(1));
	rs.next();
	System.out.println(rs.getInt(1));
	rs.previous();
	System.out.println(rs.getInt(1));
	rs.absolute(1);
	System.out.println(rs.getInt(1));
	rs.relative(10);
	System.out.println(rs.getInt(1));
	Jdbc.close(rs, stmt, conn);
	
}

}
