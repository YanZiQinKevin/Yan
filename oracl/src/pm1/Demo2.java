package pm1;


public class Demo2 {
	public Demo2(){
		i++;
	}
	static int i=1;
	static {
		i++;
	}
	
	public static void main(String[] args) {
			Demo2 d1=new Demo2();
			System.out.println(d1.i);
			
			Demo2 d2=new Demo2();
			System.out.println(d2.i);
			
		
 
	}
	
	
  


}
