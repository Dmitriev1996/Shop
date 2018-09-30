package ru.projects.Shop.interfaces.generic;

import java.util.List;

import javax.ejb.Local;

import ru.projects.Shop.entity.Client;

public interface ClientI {
	List<Client> findAllClient();
	Client findClientById(Long id);
	Client findClientByToken(String value);
	Client createClient(Client client);
	Client updateClient(Client client);
	void deleteClient(Client client);

}
