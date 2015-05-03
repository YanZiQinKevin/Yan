package pm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Demo2 {

	/**
	 * @param args
	 * @throws Exception
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, Exception {
		// TODO Auto-generated method stub
		LaLa la = new LaLa();
		System.out.println(la);
		LaLa la1 = (LaLa) Class.forName("pm.LaLa").newInstance();
		System.out.println(la1);
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
				"data.dat"));
		oo.writeObject(la);
		oo.close();
		ObjectInputStream os = new ObjectInputStream(new FileInputStream(
				"data.dat"));
		LaLa la3 = (LaLa) os.readObject();
		oo.close();
		System.out.println(la3);
	
		Object la4 = la3.clone();
        
	}

}

class LaLa implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	public LaLa() {
		System.out.println(1);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		return (LaLa) super.clone();
	}

}