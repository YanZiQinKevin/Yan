package pm1;

  public class Demo4 {
	public static void main(String[] args) {
		String s = "abcde";
		System.out.println(isrepeat(s));
	}

	public static char isrepeat(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			char c = s.charAt(i);
			for (int j = i; j < s.length(); j++) {
				char c1 = s.charAt(j);
				//System.out.println(c + " " + c1);
				if (c1 == c && i != j) {
					return c;
				}
			}
		}
		return 0;

	}
}
