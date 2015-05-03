package pm4;

public class Demo1 {

	public static Demo1 SAVE = null;

	public void islive() {
		System.out.println("alive");
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("gc");
		Demo1.SAVE = this;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SAVE = new Demo1();
		SAVE = null;
		System.gc();
		Thread.sleep(500);            
		if (SAVE != null) {
			SAVE.islive();
		} else {
			System.out.println("dead");
		}
		
     //-----------------------------------------------------------------------------
		
		SAVE = null;
	 	System.gc();
		Thread.sleep(500);
		if (SAVE != null) {
			SAVE.islive();
		} else {
			System.out.println("dead");
		}
	}
}














































































































































