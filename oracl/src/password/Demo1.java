package password;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.management.Descriptor;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream in = new FileInputStream("src/password/ps.txt");
		FileOutputStream out = new FileOutputStream("src/password/ps2.txt");
		FileOutputStream out1 = new FileOutputStream("src/password/ps3.txt");

	   
		int rs = in.read();
        int t;
   byte[] buff=new byte[1024];
		while (rs != -1) {
           t=rs;
			 t=t>>2;
		  out1.write(t);	
			out.write(rs);


			rs = in.read();
		}
		out.close();
		in.close();
		System.out.println("结束");
	}

}
