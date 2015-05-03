package password;

public class Demo3 {

	/**
	 * 子类引用父类的静态字段，不会导致子类初始化
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(SubClass.value);
	}

}

class SuperClass{
	static{
		System.out.println("SuperClass");
		
	}
	public static int value=123;
}

class SubClass extends SuperClass{
	static{
		System.out.println("SubClass");
	}
}