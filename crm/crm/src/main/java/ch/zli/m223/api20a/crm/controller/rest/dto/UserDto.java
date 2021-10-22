package ch.zli.m223.api20a.crm.controller.rest.dto;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.api20a.crm.model.AppUser;

public class UserDto {
	
	//Eigenschaften/Attribute
	
	public Long id;
	public String email;
	public List<String> roles = new ArrayList<>();;
	
	//Konstruktor
	
	public UserDto(AppUser appUser) {
		this.id= appUser.getId();
		this.email= appUser.getEmail();
		roles.addAll(appUser.getRoles());
	}
	
	
	//Methoden
	

}
