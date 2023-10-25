package com.ECommerce_Web.Model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ECOMMERCE_CART")
public class EcommerceCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="CART_ID")
	private long cartId;
		
	@OneToMany(mappedBy ="cartId")
	private List<EcommerceItem> itemId;
	
	@Column(name ="AMOUNT")
	private BigDecimal amount;

	public EcommerceCart() {
		super();
 	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public List<EcommerceItem> getItemId() {
		return itemId;
	}

	public void setItemId(List<EcommerceItem> itemId) {
		this.itemId = itemId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
}
