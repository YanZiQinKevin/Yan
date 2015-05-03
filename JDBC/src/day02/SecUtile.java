package day02;

import org.apache.commons.codec.digest.DigestUtils;

/*
 * 两种加密的算法
 */

public class SecUtile {
  public static String md5(String input){
	  
	  return DigestUtils.md2Hex(input);
  }
  public static String sha(String input){

	  return DigestUtils.sha1Hex(input);
  }
  
  
  public static void main(String[] args) {
	System.out.println(sha("1001"));
}
}
