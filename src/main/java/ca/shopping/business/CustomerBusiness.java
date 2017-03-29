package ca.shopping.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import ca.shopping.repository.CustomerRepository;
import ca.shopping.repository.entity.Customer;

public class CustomerBusiness implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9199443445287490013L;
	
	@Inject
	public CustomerRepository repository;
	
	public List<Customer> findAll() {
		return repository.findAll();
	}

	

}
