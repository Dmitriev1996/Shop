package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Region;
import ru.projects.Shop.interfaces.local.RegionLocal;

@Stateless
@Local(RegionLocal.class)
@LocalBean
public class RegionEJB implements RegionLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Region> findAllRegion() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllRegion", Region.class).getResultList();
	}

	@Override
	public Region findRegionById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Region.class, id);
	}

	@Override
	public Region createRegion(Region region) {
		// TODO Auto-generated method stub
		em.persist(region);
		return region;
	}

	@Override
	public Region updateRegion(Region region) {
		// TODO Auto-generated method stub
		return em.merge(region);
	}

	@Override
	public void deleteRegion(Region region) {
		// TODO Auto-generated method stub
		em.remove(em.merge(region));
	}

}
