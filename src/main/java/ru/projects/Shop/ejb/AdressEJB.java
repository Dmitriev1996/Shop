package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Adress;
import ru.projects.Shop.interfaces.local.AdressLocal;

@Stateless
@Local(AdressLocal.class)
@LocalBean
public class AdressEJB implements AdressLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Adress> findAllAdress() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllAdress", Adress.class).getResultList();
	}

	@Override
	public Adress findAdressById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Adress.class, id);
	}

	@Override
	public Adress createAdress(Adress adress) {
		// TODO Auto-generated method stub
		em.persist(adress);
		return adress;
	}

	@Override
	public Adress updateAdress(Adress adress) {
		// TODO Auto-generated method stub
		return em.merge(adress);
	}

	@Override
	public void deleteAdress(Adress adress) {
		// TODO Auto-generated method stub
		em.remove(em.merge(adress));;
	}

}
