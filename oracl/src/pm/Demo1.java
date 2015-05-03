package pm;
class C{
	public int i;
}
public class Demo1 {
	
	
 public void f1(C c){
	 c.i++;
	 System.out.println("A="+c.i);
 }
 public static void main(String[] args) {
	 
	C c = new C();
	c.i=10;
	
	Demo1 p = new Demo1();
	p.f1(c);
	System.out.println("b="+c.i);
 }
}


