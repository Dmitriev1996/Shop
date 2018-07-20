package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.projects.Shop.entity.Sex;
import ru.projects.Shop.interfaces.local.SexLocal;

@Stateless
@Local(SexLocal.class)
@LocalBean
public class SexEJB implements SexLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Sex> findAllSex() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllSex", Sex.class).getResultList();
	}

	@Override
	public Sex findSexById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Sex.class, id);
	}

	@Override
	public Sex createSex(Sex sex) {
		// TODO Auto-generated method stub
		em.persist(sex);
		return sex;
	}

	@Override
	public Sex updateSex(Sex sex) {
		// TODO Auto-generated method stub
		return em.merge(sex);
	}

	@Override
	public void deleteSex(Sex sex) {
		// TODO Auto-generated method stub
		em.remove(em.merge(sex));
	}

}
