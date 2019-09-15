package com.hemalatha.jcg;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;

public class GiftCodeGenerator {

	public static final String ARCFOUR_ALGORITHM = "ARCFOUR";
	public static void main(String[] args) {

		try {
			KeyGenerator keygen = KeyGenerator.getInstance(ARCFOUR_ALGORITHM);
			keygen.init(256);
			String campaignKey = Base64.encodeBase64String(keygen.generateKey().getEncoded());
			System.out.println("CampaignKey :"+campaignKey);
		}catch (NoSuchAlgorithmException e){

		}

		double t = 54*0.18;
		System.out.println(t*100);
		System.out.println(Math.round(t));
		System.out.println((int)Math.round(t));
		System.out.println((int)t);
	}
}
