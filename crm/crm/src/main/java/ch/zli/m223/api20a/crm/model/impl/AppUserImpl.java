package ch.zli.m223.api20a.crm.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ch.zli.m223.api20a.crm.model.AppUser;

@Entity(name="AppUser")
public class AppUserImpl implements AppUser{

	
	@Id // = primary Key
	@GeneratedValue // auto increment value
	private Long id;
	
	@Column(unique=true, nullable=false)
	private String email;
	
	@OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RoleImpl> roles;

	public AppUserImpl(String email, String password) {
		roles = new ArrayList<>();
		this.email = email;
	}

	protected AppUserImpl() {
		//for Jpa only
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public List<String> getRoles() {
		return roles.stream()
				.map((RoleImpl role) -> { return role.getRole(); })
				.collect(Collectors.toList());
	}

	public void addRole(RoleImpl role) {
		roles.add(role);
	}

}
