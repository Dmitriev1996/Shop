package ru.projects.Shop.ejb;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {
	  @Produces
	  @PersistenceContext(name = "Shop")
	  private EntityManager em;

}
