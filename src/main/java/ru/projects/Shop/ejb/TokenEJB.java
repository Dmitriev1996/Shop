package ru.projects.Shop.ejb;

import java.security.SecureRandom;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ru.projects.Shop.entity.Credential;
import ru.projects.Shop.entity.Token;
import ru.projects.Shop.interfaces.local.TokenLocal;

@Stateless
@Local(TokenLocal.class)
@LocalBean
public class TokenEJB implements TokenLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Token> findAllToken() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllToken", Token.class).getResultList();
	}

	@Override
	public Token findTokenById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Token.class, id);
	}

	@Override
	public Token createToken(Credential credential) {
		// TODO Auto-generated method stub
		Token token=new Token();
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String token_number = bytes.toString();
		token.setToken(token_number);
		token.setCredential(credential);
		em.persist(token);
		return token;
	}

	@Override
	public Token updateToken(Token token) {
		// TODO Auto-generated method stub
		return em.merge(token);
	}

	@Override
	public void deleteToken(Token token) {
		// TODO Auto-generated method stub
		em.remove(em.merge(token));
	}

	@Override
	public Token findTokenByValue(String value) {
		// TODO Auto-generated method stub
		TypedQuery<Token> query=em.createNamedQuery("findTokenByValue", Token.class);
		query.setParameter("token", value);
		Token token=query.getSingleResult();
		return token;
	}

}
