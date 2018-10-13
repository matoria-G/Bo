package com.bo.commons.core;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Commons {
	public static byte[] hashPassword(String password) {
	    byte[] salt = new byte[16];
	    byte[] hash = null;
	    for (int i = 0; i < 16; i++) {
	        salt[i] = (byte) i;
	    }
	    try {
	        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
	        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	        hash = f.generateSecret(spec).getEncoded();
	
	    } catch (NoSuchAlgorithmException nsale) {
	        nsale.printStackTrace();
	
	    } catch (InvalidKeySpecException ikse) {
	        ikse.printStackTrace();
	    }
	    return hash;
	}
	public static int distance(double lat1, double lat2, double lon1,
	        double lon2, double el1, double el2) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    return (int) Math.ceil(Math.sqrt(distance));
	}
		

}