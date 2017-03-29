package ca.shopping.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ca.shopping.repository.entity.Order;

/**
 * OrderRepository
 * @author Felipe
 *
 */
@ApplicationScoped
public class OrderRepository  implements Serializable {

	
	private static final long serialVersionUID = -4689031898494269011L;
	@Inject
	private EntityManager em;

	/**
	 * Find Order Customer
	 * @param customerId - id of the table Customer
	 * @return
	 */
	public List<Order> findOrderCustomer(Long customerId) {
		return em.createQuery("select o from Order o where exists (select c from Customer c  where o.customer = c and c.customerNumber=:customerId) order by o.orderDate", Order.class).setParameter("customerId", customerId).getResultList();

	}


}
