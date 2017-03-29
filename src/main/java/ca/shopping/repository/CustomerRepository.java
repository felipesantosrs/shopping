package ca.shopping.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ca.shopping.repository.entity.Customer;
/**
 * Customer Repository
 * @author Felipe
 *
 */
@ApplicationScoped
public class CustomerRepository implements Serializable {

	private static final long serialVersionUID = 429953894448986765L;
	
	@Inject
	private EntityManager em;
	
	
	/**
	 * Find all the customer
	 * @return
	 */
	public List<Customer> findAll() {
		 return em.createQuery("select c from Customer c", Customer.class)
				  .getResultList();

	}

}
