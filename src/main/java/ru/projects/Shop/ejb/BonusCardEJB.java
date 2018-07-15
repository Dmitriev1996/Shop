package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.BonusCard;
import ru.projects.Shop.interfaces.local.BonusCardLocal;

@Stateless
@Local(BonusCardLocal.class)
@LocalBean
public class BonusCardEJB implements BonusCardLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<BonusCard> findAllBonusCard() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllBonusCard", BonusCard.class).getResultList();
	}

	@Override
	public BonusCard findBonusCardById(Long id) {
		// TODO Auto-generated method stub
		return em.find(BonusCard.class, id);
	}

	@Override
	public BonusCard createBonusCard(BonusCard bonuscard) {
		// TODO Auto-generated method stub
		em.persist(bonuscard);
		return bonuscard;
	}

	@Override
	public BonusCard updateBonusCard(BonusCard bonuscard) {
		// TODO Auto-generated method stub
		return em.merge(bonuscard);
	}

	@Override
	public void deleteBonusCard(BonusCard bonuscard) {
		// TODO Auto-generated method stub
		em.remove(em.merge(bonuscard));
	}

}
