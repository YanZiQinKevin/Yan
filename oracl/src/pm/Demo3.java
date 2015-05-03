package pm;

public class Demo3 {

  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
              String s="上海自来水来自海上";
              Demo3 demo3=new Demo3();
           if(demo3.huiString(s)){
        	   System.out.println("回文");
           }
	}
	
   public boolean huiString(String s){
	    String s1=""; 
	    String s2="";
	   for(int i=0;i<s.length();i++){
	        	   char c=s.charAt(i);
	        	   s1+=c;
	           }
	   for(int j=s1.length()-1;j>=0;j--){
		   char c=s.charAt(j);
    	   s2+=c;
	   }
	   if(s1.equals(s2)){
     	  return true;
      
}
	   
	   return false;
   }
}
