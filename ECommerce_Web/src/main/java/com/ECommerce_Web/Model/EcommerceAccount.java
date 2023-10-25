package com.ECommerce_Web.Model;

import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ECOMMERCE_ACCOUNT")
public class EcommerceAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ACCOUNT_ID")
	private long accountId;
	
	@Column(name ="ITEM_NAME")
	private String itemName;
	
	@Column(name ="DESCRIPTION")
	private String description;
	
	@Column(name ="AMOUNT")
	private BigDecimal amount;
	
	@Column(name ="STATUS")
	private boolean status;
	
	@JoinColumn(name ="ITEM_ID")
	@ManyToOne
	private EcommerceItem ecommerceItem;
	
	@JoinColumn(name ="USER_ID")
	@ManyToOne
	private EcommerceUser ecommerceUser;
	
	

	public EcommerceAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public EcommerceItem getEcommerceItem() {
		return ecommerceItem;
	}

	public void setEcommerceItem(EcommerceItem ecommerceItem) {
		this.ecommerceItem = ecommerceItem;
	}

	public EcommerceUser getEcommerceUser() {
		return ecommerceUser;
	}

	public void setEcommerceUser(EcommerceUser ecommerceUser) {
		this.ecommerceUser = ecommerceUser;
	}
	
	

}
