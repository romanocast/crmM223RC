package ch.zli.m223.api20a.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.api20a.crm.exception.InvalidParamException;
import ch.zli.m223.api20a.crm.exception.UserAlreadyExistsException;
import ch.zli.m223.api20a.crm.exception.UserNotFoundException;
import ch.zli.m223.api20a.crm.model.AppUser;
import ch.zli.m223.api20a.crm.repository.RoleRepository;
import ch.zli.m223.api20a.crm.repository.UserRepository;
import ch.zli.m223.api20a.crm.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<AppUser> getAllUsers() {
		
		return new ArrayList<AppUser>(userRepository.findAll());
	}

	@Override
	public AppUser getUserById(long id) {
		
		return userRepository.findById(id)
				.orElseThrow(UserNotFoundException::new);
	}

	@Override
	public void deleteById(long id) {
		
		 getUserById(id);
		 userRepository.deleteById(id);
	}

	@Override
	public AppUser addUser(String email, String password) {
		
		//Check parameter for null orElse throw exception
		if(email == null || password == null) {
			throw new InvalidParamException();
		} 
		//Check for duplication in email orElse throw exception
		if(userRepository.findByEmail(email).isPresent()) {
			throw new UserAlreadyExistsException();
		}
		//Insert (email/password) as AppUser in database
		return userRepository.add(email, password);
	}

	@Override
	public AppUser setRolesForUser(long userId, List<String> roles) {
		
		//Check if user exists
		AppUser user = getUserById(userId);	
		//Check if role is null
		if(roles == null) {
			throw new InvalidParamException();
		}
		//Add the role list to the User and save it to the db
		return roleRepository.setRoles(user, roles);
	}
}
