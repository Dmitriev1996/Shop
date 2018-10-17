package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.Credential;
import ru.projects.Shop.entity.Token;

public interface TokenI {
	List<Token> findAllToken();
	Token findTokenById(Long id);
	Token findTokenByValue(String value);
	Token createToken(Credential credential);
	Token updateToken(Token token);
	void deleteToken(Token token);

}
