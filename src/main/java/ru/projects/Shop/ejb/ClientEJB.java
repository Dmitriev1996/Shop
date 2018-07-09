package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.projects.Shop.entity.Client;
import ru.projects.Shop.interfaces.local.ClientLocal;

@Stateless
@Local(ClientLocal.class)
@LocalBean
public class ClientEJB implements ClientLocal {
	@Produces
	@PersistenceContext(name="Shop")
	private EntityManager em;

	public List<Client> findAllClient() {
		return em.createNamedQuery("findAllClient", Client.class).getResultList();
	}

	public Client findClientById(Long id) {
		return em.find(Client.class, id);
	}

	public Client createClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	public Client deleteClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
