package ca.shopping.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ca.shopping.repository.entity.Product;

/**
 * Product Repository
 * @author Felipe
 *
 */
public class ProductRepository implements Serializable{

	private static final long serialVersionUID = -3190379074454028413L;
	
	@Inject
	private EntityManager em;

	/**
	 * Find product for Order
	 * @param orderId
	 * @return
	 */
	public List<Long> findOrderProduct(Long orderId) {
		Query q = em.createNativeQuery("SELECT p.productCode FROM  products p where p.productCode in ( select d.productCode from orderdetails d where exists (select 1 from orders o  where d.orderNumber = o.orderNumber and o.orderNumber=?)) ");
		q.setParameter(1, orderId);
		return (List<Long>) q.getResultList();
	}
	
	/**
	 * Find product by Ids
	 * @param productsId
	 * @return
	 */
	public List<Product> findProductByIds(List<Long> productsId) {
			return em.createQuery("select p from Product p where  p.productCode in (:productsId))", Product.class).setParameter("productsId", productsId).getResultList();

		}

}
