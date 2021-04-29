package com.ibm.motoInsure.EncodeDecode;
import java.util.Base64;

public class Encryption {
	private static Encryption encrypter = new Encryption(); 
	
	private Encryption(){}
	
	public static Encryption getEncrypter() {
		return encrypter;
	}	
	
	public String EncodePassword(String pwd) {
		return  Base64.getEncoder().encodeToString(pwd.getBytes());
	}
	
	public String DecodePassword(String pwd) {
		return new String(Base64.getDecoder().decode(pwd.getBytes()));
	}

}




