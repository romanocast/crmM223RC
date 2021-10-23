package ch.zli.m223.api20a.crm.model;

import java.util.List;

public interface Customer {

	public Long getId();
	public String getName();
	public String getStreet();
	public String getCity();
	List<Memo> getMemos();
}
