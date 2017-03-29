package ca.shopping.repository.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class OrderDTO implements Serializable {

	public OrderDTO(Long orderNumber, Date orderDate, Date requiredDate, Date shippedDate, String status,
			String comments, List<ProductDTO> products) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.products = products;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5539720963739480058L;

	
	private Long orderNumber;

	private Date orderDate;
	private Date requiredDate;

	private Date shippedDate;

	private String status;

	private String comments;
	
	private List<ProductDTO> products;
	
	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


}
