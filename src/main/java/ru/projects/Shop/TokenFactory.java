package ru.projects.Shop;

import java.security.SecureRandom;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ru.projects.Shop.ejb.TokenEJB;
import ru.projects.Shop.entity.Credential;
import ru.projects.Shop.entity.Token;

@Stateless
public class TokenFactory {
	@Inject
	private static TokenEJB tokenEJB;
	public static Token createToken(Credential credential) {
		Token token=new Token();
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String token_number = bytes.toString();
		token.setToken(token_number);
		token.setCredential(credential);
		return tokenEJB.createToken(token);
	}

}
