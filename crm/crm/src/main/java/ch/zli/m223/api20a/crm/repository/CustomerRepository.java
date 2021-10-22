package ch.zli.m223.api20a.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.api20a.crm.model.Customer;
import ch.zli.m223.api20a.crm.model.impl.CustomerImpl;

public interface CustomerRepository extends JpaRepository<CustomerImpl, Long>{
	
	public Optional<CustomerImpl> findCustomerByName(String name);
	
	public default Customer add(String name, String street, String city) {
		return save(new CustomerImpl(name, street, city));
	}
}

