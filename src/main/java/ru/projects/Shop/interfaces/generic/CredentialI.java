package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.Credential;

public interface CredentialI {
	Credential createCredential(Credential credential);
	List<Credential> findAllCredential();
	Credential findCredentialById(Long id);
	Credential updateCredential(Credential credential);
	void deleteCredential(Credential credential);

}
