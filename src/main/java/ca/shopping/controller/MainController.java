package ca.shopping.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ca.shopping.business.CustomerBusiness;
import ca.shopping.business.OrderBusiness;
import ca.shopping.repository.dto.OrderDTO;
import ca.shopping.repository.entity.Customer;
import ca.shopping.util.ViewUtils;

@Named(value = "mainController")
@ApplicationScoped
public class MainController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1931151044688160637L;

	@Inject
	private CustomerBusiness business;

	@Inject
	private OrderBusiness orderBusiness;

	private List<Customer> customers;
	
	private List<OrderDTO> orders;
	
	private OrderDTO orderSelected;
	
	private Long idCustomer;

	public void init() {
		setCustomers(business.findAll());
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public Long getIdCustomer() {
 		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	/**
	 * Find Order of Customer that has been selected
	 */
	public void search() {
		if (getIdCustomer()== null) {
			ViewUtils.errorMessage("You should select a customer" );
		}else{
			setOrders(orderBusiness.findOrderCustomer(getIdCustomer()));
		}
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}


	public OrderDTO getOrderSelected() {
		return orderSelected;
	}

	public void setOrderSelected(OrderDTO orderSelected) {
		this.orderSelected = orderSelected;
	}
}
