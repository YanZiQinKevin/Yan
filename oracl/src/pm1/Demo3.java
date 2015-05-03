package pm1;

public class Demo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String s="abcba";
       System.out.println(isPalindrome(s));
		
	}
     public static boolean isPalindrome(String s){
    	 StringBuilder sb=new StringBuilder(s);
    	 String reverse=sb.reverse().toString();
    	 return s.equals(reverse);
    	 
     }
}
