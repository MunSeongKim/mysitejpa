package com.cafe24.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPassword {
    public static String encrypt( String source ) {
	String encryptedString = null;
	try {
	    MessageDigest SHA256Encrypt = MessageDigest.getInstance( "SHA-256" );
	    SHA256Encrypt.update( source.getBytes(), 0, source.length() );
	    encryptedString = new BigInteger( 1, SHA256Encrypt.digest() ).toString( 16 );
	} catch ( NoSuchAlgorithmException e ) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return encryptedString;
    }
}
