package webdriver_practice;

import org.apache.commons.codec.binary.Base64;

public class Encrypt_Decrypt {

	public static void main(String[] args) {
		
		String str = "abcd";
		
		byte[] encode = Base64.encodeBase64(str.getBytes());
		
		//String str1 = new String (encode);
		//System.out.println(str1);
		
		System.out.println(new String (encode));
		
		byte[] decode = Base64.decodeBase64(encode);
		
		System.out.println(new String (decode));
			

	}

}
