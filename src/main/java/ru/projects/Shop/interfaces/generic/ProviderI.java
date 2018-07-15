package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.Provider;

public interface ProviderI {
	List<Provider> findAllProvider();
	Provider findProviderById(Long id);
	Provider createProvider(Provider provider);
	Provider updateProvider(Provider provider);
	void deleteProvider(Provider provider);

}
