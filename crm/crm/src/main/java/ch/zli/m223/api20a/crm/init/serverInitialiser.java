package ch.zli.m223.api20a.crm.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.api20a.crm.model.impl.AppUserImpl;
import ch.zli.m223.api20a.crm.repository.RoleRepository;
import ch.zli.m223.api20a.crm.repository.UserRepository;

@Component
public class serverInitialiser implements ApplicationRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> roles = new ArrayList<>();
		roles.add("chef"); roles.add("büetzer");
		AppUserImpl user = userRepository.save(new AppUserImpl("sankeTheRiddelFiddel@budugama.jupi", "hans-jörg"));
		roleRepository.setRoles(user, roles);
		
		userRepository.save(new AppUserImpl("sagurkel@budugama.jupi", "hans-jörg"));
	}

	
}
