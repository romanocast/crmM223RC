package ch.zli.m223.api20a.crm.service;

import java.util.List;
import java.util.Optional;

import ch.zli.m223.api20a.crm.model.Customer;
import ch.zli.m223.api20a.crm.model.impl.CustomerImpl;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerById(long id);

	void deleteById(long id);

	Optional<CustomerImpl> getCustomerByName(String name);
	
	Customer addCustomer(String name, String street, String city);

	Customer setMemosForCustomer(long id, String memos);

}
