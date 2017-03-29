package ca.shopping.repository.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6338462685602048260L;

	private String productName;
	private BigDecimal buyPrice;

	public ProductDTO(String productName, BigDecimal buyPrice) {
		super();
		this.productName = productName;
		this.buyPrice = buyPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

}
