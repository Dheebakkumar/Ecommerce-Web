package com.ECommerce_Web.Model;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name ="ECOMMERCE_ITEM")
public class EcommerceItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ITEM_ID")
	private long itemId;
	
	@Column(name ="NAME")
	private String name;
	
	@JoinColumn(name ="CATEGORY_ID")
	@ManyToOne
	private EcommerceCategory ecommerceCategory;
	
	@JoinColumn(name ="VENDOR_ID")
	@ManyToOne
	private EcommerceVendor ecommerceVendor;
	
	@Column(name ="AMOUNT")
	private BigDecimal amount;
	
	@Column(name ="DESCRIPTION")
	private String description;
	
	@Column(name ="STATUS")
	private boolean status;
	
	@JoinColumn(name ="CART_ID")
	@ManyToOne
	private EcommerceCart cartId;
	
	@Column(name ="QUANTITY")
	private long quantity;
	
	@Column(name ="CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name ="UPDATED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public EcommerceItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	

	public EcommerceCart getCartId() {
		return cartId;
	}

	public void setCartId(EcommerceCart cartId) {
		this.cartId = cartId;
	}

	public EcommerceCategory getEcommerceCategory() {
		return ecommerceCategory;
	}

	public void setEcommerceCategory(EcommerceCategory ecommerceCategory) {
		this.ecommerceCategory = ecommerceCategory;
	}

	public EcommerceVendor getEcommerceVendor() {
		return ecommerceVendor;
	}

	public void setEcommerceVendor(EcommerceVendor ecommerceVendor) {
		this.ecommerceVendor = ecommerceVendor;
	}

	
	
	
	
	
	
}
