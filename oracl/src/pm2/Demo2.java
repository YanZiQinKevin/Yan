package pm2;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

public class Demo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
               String input="total";
               char[] array=input.toCharArray();
               for(char tmp:array){
            	   int first=input.indexOf(tmp);
            	      int last=input.lastIndexOf(tmp);
            	      if(first==last){
            	    	  System.out.println(tmp);
            	    	  break;
            	      }
            	   
               }
	}

}
