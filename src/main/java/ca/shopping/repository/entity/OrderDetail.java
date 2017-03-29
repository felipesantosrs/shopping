package ca.shopping.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orderdetails")
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1655492086389041962L;

	@Id
	@Column(name = "orderLineNumber")
	private Integer orderLineNumber;
	
	@ManyToOne
	@JoinColumn(name = "orderNumber")
	private Order order;
	

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name = "productCode")
	private List<Product> products;
	
	@Column(name = "quantityOrdered")
	private Integer quantityOrdered;
	
	@Column(name = "priceEach")
	private BigDecimal priceEach;

	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public BigDecimal getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(BigDecimal priceEach) {
		this.priceEach = priceEach;
	}

	public Integer getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(Integer orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	
}
