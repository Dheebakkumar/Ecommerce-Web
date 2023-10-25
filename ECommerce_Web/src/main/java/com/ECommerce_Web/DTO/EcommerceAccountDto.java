package com.ECommerce_Web.DTO;

import java.math.BigDecimal;

import com.ECommerce_Web.Model.EcommerceItem;
import com.ECommerce_Web.Model.EcommerceUser;


public class EcommerceAccountDto {

	private long accountId;
	
	private String itemName;
	
	private String description;
	
	private BigDecimal amount;
	
	private boolean status;
	
	private long itemId;
	
	private long userId;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	
	
}
