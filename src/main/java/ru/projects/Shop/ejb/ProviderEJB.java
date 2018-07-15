package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Provider;
import ru.projects.Shop.interfaces.local.ProviderLocal;

@Stateless
@Local(ProviderLocal.class)
@LocalBean
public class ProviderEJB implements ProviderLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Provider> findAllProvider() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllProvider", Provider.class).getResultList();
	}

	@Override
	public Provider findProviderById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Provider.class, id);
	}

	@Override
	public Provider createProvider(Provider provider) {
		// TODO Auto-generated method stub
		em.persist(provider);
		return provider;
	}

	@Override
	public Provider updateProvider(Provider provider) {
		// TODO Auto-generated method stub
		return em.merge(provider);
	}

	@Override
	public void deleteProvider(Provider provider) {
		// TODO Auto-generated method stub
		em.remove(em.merge(provider));
	}

}
