package pm;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="上海自来水来自海上";
int j=s.length()-1;
for(int i=0;i<s.length()-1;i++){
	char c0=s.charAt(j);
   char c1=s.charAt(i);
   System.out.println(c0);
   System.out.println(c1);
   if(j==((s.length()-1)/2)){
     break;
     }
   j--;
   }
     if(j==(s.length()-1)/2){
     System.out.println("回文");
    }else {
		System.out.println("不是");
	}
 }
}
