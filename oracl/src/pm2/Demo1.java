package pm2;
public class Demo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String reg="^[\\w\u4e00-\u9fa5]{4,7}$";
//         String input="abcd1";
            String input="横行青海";
         System.out.println(input.matches(reg));
		
		//网址
         reg="^(http)\\://(\\w*\\.\\w+\\.\\w+(\\.\\w+)?)$";
         input="http://www.163.com";
         System.out.println(input.matches(reg));
         
         
	}

}
