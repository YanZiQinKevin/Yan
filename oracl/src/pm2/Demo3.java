package pm2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "1234234656666789";
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			String a = input.substring(i, i + 1);
			list.add(a);
		}
		Set<String> set = new HashSet<String>(list);
		list.clear();
		list.addAll(set);
		Collections.sort(list);
		System.out.println(list);
	}

}
