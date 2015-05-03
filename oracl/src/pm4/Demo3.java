package pm4;

import com.sun.org.apache.xpath.internal.operations.And;

public class Demo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          String user="s12";
          String nn="45";
         
          // 6+6='         s12            '
          String sql="6+6="+user;
          System.out.println(sql);
          System.out.println("6+6='"+user+"'");
          int i=1+1;
               i+=1;
String sql2="select count(*) from emp_mjc2 where name='"+user+"'and pwd='"+nn+"'";              
          
	}

}
