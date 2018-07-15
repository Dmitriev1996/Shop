package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.TransportationType;
import ru.projects.Shop.interfaces.local.TransportationTypeLocal;

@Stateless
@Local(TransportationTypeLocal.class)
@LocalBean
public class TransportationTypeEJB implements TransportationTypeLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<TransportationType> findAllTransportationType() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllTransportationType", TransportationType.class).getResultList();
	}

	@Override
	public TransportationType findTransportationTypeById(Long id) {
		// TODO Auto-generated method stub
		return em.find(TransportationType.class, id);
	}

	@Override
	public TransportationType createTransportationType(TransportationType transtype) {
		// TODO Auto-generated method stub
		em.persist(transtype);
		return transtype;
	}

	@Override
	public TransportationType updateTransportationType(TransportationType transtype) {
		// TODO Auto-generated method stub
		return em.merge(transtype);
	}

	@Override
	public void deleteTransportationType(TransportationType transtype) {
		// TODO Auto-generated method stub
		em.remove(em.merge(transtype));
	}

}
