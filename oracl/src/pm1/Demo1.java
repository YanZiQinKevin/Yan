package pm1;

import java.lang.reflect.Field;

import javax.activation.FileDataSource;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
     String s="abc"+10+"hello"+1 ;
     String s1="abc";
       int i=10;
        int t=10;
     
        
     Field field = String.class.getDeclaredField("value");
     Field field1=int.class.getDeclaredField("value1");
		field.setAccessible(true);
		field1.setAccessible(true);
		//int value1=(int) field.get(i); 
		char[] value = (char[]) field.get(s);
		value[0] = 'j';
	//	value1=2;
		System.out.println(i);
		System.out.println(t);
     System.out.println(s);
     System.out.println(s1);
     
     
	}

}
