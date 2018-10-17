package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionRolledbackLocalException;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import ru.projects.Shop.entity.Credential;
import ru.projects.Shop.interfaces.local.CredentialLocal;

@Stateless
@Local(CredentialLocal.class)
@LocalBean
public class CredentialEJB implements CredentialLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Credential> findAllCredential() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllCredential", Credential.class).getResultList();
	}

	@Override
	public Credential findCredentialById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Credential.class, id);
	}

	@Override
	public Credential updateCredential(Credential credential) {
		// TODO Auto-generated method stub
		return em.merge(credential);
	}

	@Override
	public void deleteCredential(Credential credential) {
		// TODO Auto-generated method stub
		em.remove(em.merge(credential));
	}

	@Override
	public Credential createCredential(Credential credential) {
		// TODO Auto-generated method stub
		em.persist(credential);
		return credential;
	}

	@Override
	public Credential checkUser(Credential credential) throws NoResultException,TransactionRolledbackLocalException {
		// TODO Auto-generated method stub
		TypedQuery<Credential> query=em.createNamedQuery("checkUser", Credential.class);
		query.setParameter("login", credential.getLogin());
		query.setParameter("password", credential.getPassword());
	    Credential result=query.getSingleResult();
		return result;
	    
	}

}
