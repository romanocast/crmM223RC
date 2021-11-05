package ch.zli.m223.api20a.crm.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.api20a.crm.controller.rest.dto.UserDto;
import ch.zli.m223.api20a.crm.controller.rest.dto.UserInputDto;
import ch.zli.m223.api20a.crm.model.AppUser;
import ch.zli.m223.api20a.crm.service.UserService;

/**
 * This is the rest-controller for users
 */
@RestController
@RequestMapping("/api/v0/users")
public class UserRestController {

	//Spring itself searches an service, and injects it here
	@Autowired
	private UserService userService;
	
	//Get a list of all users
	@GetMapping("")
	public List<UserDto> getAllUsers() {

		List<AppUser> users = userService.getAllUsers();
		return users.stream()
			.map((AppUser user) -> { return new UserDto(user);
			}).collect(Collectors.toList());
	}
	
	//get every information of one user (by id)
	@GetMapping("/{id}")
	public UserDto getUserById(@PathVariable("id") long id) {
		
		return new UserDto(userService.getUserById(id));
	}

	//delete an user by his id
	@DeleteMapping("/{id}/delete")
	public void deleteById(@PathVariable("id") long id) {
		
		userService.deleteById(id);
	}
	
	//add an new user with a post
	@PostMapping("")
	public UserDto addUser(@RequestBody UserInputDto user) {
		
		return new UserDto(userService.addUser(user.email, user.password));
	}
	
	//add a new role to an user
	@PostMapping("{id}/roles")
	public UserDto setRoles(@PathVariable("id") long userId, @RequestBody List<String> roles) {
		
			return new UserDto(userService.setRolesForUser(userId, roles));
	}
}
