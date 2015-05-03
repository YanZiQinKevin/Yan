package pm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "1234234656666789";
		char[] c=input.toCharArray();
		
        
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			Character s = input.charAt(i);
			set.add(s);
		}

		List<Character> list = new ArrayList<Character>(set);
		Collections.sort(list);
		System.out.println(list);
	}

}
