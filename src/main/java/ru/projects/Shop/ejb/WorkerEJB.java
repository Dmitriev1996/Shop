package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Worker;
import ru.projects.Shop.interfaces.local.WorkerLocal;

@Stateless
@Local(WorkerLocal.class)
@LocalBean
public class WorkerEJB implements WorkerLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Worker> findAllWorker() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllWorker", Worker.class).getResultList();
	}

	@Override
	public Worker findWorkerById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Worker.class, id);
	}

	@Override
	public Worker createWorker(Worker worker) {
		// TODO Auto-generated method stub
		em.persist(worker);
		return worker;
	}

	@Override
	public Worker updateWorker(Worker worker) {
		// TODO Auto-generated method stub
		return em.merge(worker);
	}

	@Override
	public void deleteWorker(Worker worker) {
		// TODO Auto-generated method stub
		em.remove(em.merge(worker));
	}

}
