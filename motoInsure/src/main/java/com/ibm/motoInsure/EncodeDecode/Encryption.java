package com.ibm.motoInsure.EncodeDecode;
import java.util.Base64;
/**
 * <p>This class is for secure password of user</p>
 * @author Jai Baheti
 * @since 18-04-2021
 */
public class Encryption {
	private static Encryption encrypter = new Encryption(); 
	
	private Encryption(){}
	
	public static Encryption getEncrypter() {
		return encrypter;
	}	
	/**
	 * 
	 * @param pwd
	 * @return encrypted password
	 */
	public String EncodePassword(String pwd) {
		return  Base64.getEncoder().encodeToString(pwd.getBytes());
	}
	/**
	 * 
	 * @param pwd
	 * @return decrypted password
	 */
	public String DecodePassword(String pwd) {
		return new String(Base64.getDecoder().decode(pwd.getBytes()));
	}

}




