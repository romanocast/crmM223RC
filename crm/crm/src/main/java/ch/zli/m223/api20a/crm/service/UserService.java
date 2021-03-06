package ch.zli.m223.api20a.crm.service;

import java.util.List;

import ch.zli.m223.api20a.crm.model.AppUser;

public interface UserService {

	List<AppUser> getAllUsers();

	AppUser getUserById(long id);

	void deleteById(long id);

	AppUser addUser(String email, String passwort);

	AppUser setRolesForUser(long userId, List<String> roles);


}
