import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt = null;
		//加载驱动程序
		try {
			 //加载驱动程序
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//获取一个数据库链接
			
			conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.42:1521:orcl","s01","s01");
			//依据链接创建SQL对象
		
			stmt=conn.createStatement();
			//执行语句
			String sql="insert into dept_kevin values(90,'account','兰州')";
			stmt.executeUpdate(sql);
			//获取
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
