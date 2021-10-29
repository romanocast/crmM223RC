package ch.zli.m223.api20a.crm.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

	private String hashedPassword;

	public AppUserImpl(String email, String password) {
		
		roles = new ArrayList<>();
		hashedPassword = new BCryptPasswordEncoder().encode(password);
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return getRoles().stream()
			.map((role) -> { return new SimpleGrantedAuthority(role);})
			.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {

		return hashedPassword;
	}

	@Override
	public String getUsername() {
		
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
