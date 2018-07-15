package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.TypeProduct;
import ru.projects.Shop.interfaces.local.TypeProductLocal;

@Stateless
@Local(TypeProductLocal.class)
@LocalBean
public class TypeProductEJB implements TypeProductLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<TypeProduct> findAllTypeProduct() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllTypeProduct", TypeProduct.class).getResultList();
	}

	@Override
	public TypeProduct findTypeProductById(Long id) {
		// TODO Auto-generated method stub
		return em.find(TypeProduct.class, id);
	}

	@Override
	public TypeProduct createTypeProduct(TypeProduct typeproduct) {
		// TODO Auto-generated method stub
		em.persist(typeproduct);
		return typeproduct;
	}

	@Override
	public TypeProduct updateTypeProduct(TypeProduct typeproduct) {
		// TODO Auto-generated method stub
		return em.merge(typeproduct);
	}

	@Override
	public void deleteTypeProduct(TypeProduct typeproduct) {
		// TODO Auto-generated method stub
		em.remove(em.merge(typeproduct));
	}

}
