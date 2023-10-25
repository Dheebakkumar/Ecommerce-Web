package com.ECommerce_Web.DTO;

import java.math.BigDecimal;
import java.util.List;

import com.ECommerce_Web.Model.EcommerceItem;

public class EcommerceCartDto {
	
	private long cartId;
	
	private List<EcommerceItem> itemId;
	
	private BigDecimal amount;

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
