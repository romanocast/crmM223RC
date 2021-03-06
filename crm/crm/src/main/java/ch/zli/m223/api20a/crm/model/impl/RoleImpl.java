package ch.zli.m223.api20a.crm.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.zli.m223.api20a.crm.model.Role;

@Entity(name = "Role")
public class RoleImpl implements Role {
	
	@Id
	@GeneratedValue
	private Long id;
	private String role;
	
	@ManyToOne
	private AppUserImpl appUser;
	
	public RoleImpl(String role, AppUserImpl user) {
		appUser = user;
		this.role = role;
	}
	
	protected RoleImpl() {
		//For Jpa only
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getRole() {
		return role;
	}

}
