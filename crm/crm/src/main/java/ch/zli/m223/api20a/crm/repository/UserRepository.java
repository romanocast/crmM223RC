package ch.zli.m223.api20a.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.api20a.crm.model.AppUser;
import ch.zli.m223.api20a.crm.model.impl.AppUserImpl;

public interface UserRepository extends JpaRepository<AppUserImpl, Long>{

	public Optional<AppUserImpl> findByEmail(String email);

	public default AppUser add(String email, String password) {
		return save(new AppUserImpl(email, password));
	};
}
