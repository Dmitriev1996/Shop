package ru.projects.Shop;

import java.security.SecureRandom;

import ru.projects.Shop.entity.Credential;
import ru.projects.Shop.entity.Token;

public class TokenFactory {
	public static Token createToken(Credential credential) {
		Token token=new Token();
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String token_number = bytes.toString();
		token.setToken(token_number);
		token.setCredential(credential);
		return token;
	}

}
