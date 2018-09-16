package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.Token;

public interface TokenI {
	List<Token> findAllToken();
	Token findTokenById(Long id);
	Token createToken(Token token);
	Token updateToken(Token token);
	void deleteToken(Token token);

}
