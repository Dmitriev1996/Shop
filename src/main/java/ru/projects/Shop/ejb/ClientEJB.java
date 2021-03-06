package ru.projects.Shop.ejb;

import java.util.List;

import java.util.logging.Logger;
import java.util.logging.Level;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Token;
import ru.projects.Shop.interfaces.local.ClientLocal;


@Stateless
@Local(ClientLocal.class)
@LocalBean
public class ClientEJB implements ClientLocal {
	@Inject
	private EntityManager em;
	
	@Inject
	private TokenEJB tokenEJB;
	

	public List<Client> findAllClient() {
		return em.createNamedQuery("findAllClient", Client.class).getResultList();
	}

	public Client findClientById(Long id) {
		return em.find(Client.class, id);
	}

	public Client createClient(Client client) {
		// TODO Auto-generated method stub
			em.persist(client);
		    return client;
	}

	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return em.merge(client);
	}

	public void deleteClient(Client client) {
		// TODO Auto-generated method stub
		em.remove(em.merge(client));
	}

	@Override
	public Client findClientByToken(String value) {
		// TODO Auto-generated method stub
		Token token=tokenEJB.findTokenByValue(value);
		return token.getCredential().getClient();
	}


}
