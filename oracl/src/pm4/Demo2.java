package pm4;

public class Demo2 {
   static class Syn implements  Runnable {
   int a,b;
   public Syn(int a,int b){
	   this.a=a;
	   this.b=b;
   }
   
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (Integer.valueOf(a)) {
			synchronized (Integer.valueOf(b)) {
				System.out.println(a+b);
			}
		}
	}
	
	   
   } 
	


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
  for(int i=0;i<100;i++){
	  new Thread(new Syn(1,2)).start();
	  new Thread(new Syn(2,1)).start();

  }
	}

}
