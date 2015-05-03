package pm2;

import java.util.Arrays;
import java.util.Collections;

public class Demo6 {
	public static void main(String[] args) {
		 String input="1234234656666789";
		 String s = "";
		 char c;
		 for(int i=0;i<input.length();i++){
			 c=input.charAt(i);
		  try {
			 if(s.indexOf(c)==-1){
				 s=s+c;
			 }
				} catch (Exception e) {
					 c=input.charAt(0);
					s=s+c;
				}
		 }
		char[] c1=s.toCharArray(); 
		Arrays.sort(c1);
        System.out.println(c1);
	}

}
