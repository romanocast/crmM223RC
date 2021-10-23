package ch.zli.m223.api20a.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.api20a.crm.model.Customer;
import ch.zli.m223.api20a.crm.model.impl.CustomerImpl;
import ch.zli.m223.api20a.crm.model.impl.MemoImpl;

public interface MemoRepository extends JpaRepository<MemoImpl, Long>{

	public default Customer setMemos(Customer editCustomer, String memos) {
		CustomerImpl customer = (CustomerImpl)editCustomer;
		save(new MemoImpl(memos, customer));
		return editCustomer;
	}
}
