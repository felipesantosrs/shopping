package ca.shopping.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ca.shopping.repository.OrderRepository;
import ca.shopping.repository.ProductRepository;
import ca.shopping.repository.dto.OrderDTO;
import ca.shopping.repository.dto.ProductDTO;
import ca.shopping.repository.entity.Order;
import ca.shopping.repository.entity.Product;


/**
 * OrderBusiness class
 * @author Felipe
 *
 */
public class OrderBusiness implements Serializable {


	private static final long serialVersionUID = 2192482395441028071L;
	@Inject
	OrderRepository repository;

	@Inject
	ProductRepository productRepository;

	public List<OrderDTO> findOrderCustomer(Long idCustomer) {
		List<Order> orders = repository.findOrderCustomer(idCustomer);
		List<OrderDTO> dtos = new ArrayList<OrderDTO>();
		orders.forEach(order -> {
			List<Long> idOrderStrings = productRepository.findOrderProduct(order.getOrderNumber());
			List<Product> products = productRepository.findProductByIds(idOrderStrings);
			List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
			products.forEach(p -> {
				productDTOs.add(new ProductDTO(p.getProductName(), p.getBuyPrice()));
			});

			dtos.add(new OrderDTO(order.getOrderNumber(), order.getOrderDate(), order.getOrderDate(),
					order.getShippedDate(), order.getStatus(), order.getComments(), productDTOs));

		});
		return dtos;

	}

}
