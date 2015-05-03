package pm2;

import java.util.TreeSet;

public class Demo4 {
	public static void main(String[] args) {
		TreeSet<String> tSet = new TreeSet<String>();
		String input = "1234234656666789";
		for (int i = 0; i < input.length(); i++) {
			tSet.add(input.substring(i, i + 1));
		}
		System.out.println(tSet);
	}
}