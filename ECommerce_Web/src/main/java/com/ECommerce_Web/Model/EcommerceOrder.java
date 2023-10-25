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
import jakarta.persistence.OneToOne; 
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name ="ECOMMERCE_ORDER")
public class EcommerceOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ORDER_ID")
	private long orderId;
	
	@JoinColumn(name ="CART_ID")
	@OneToOne
	private EcommerceCart cartId;
	
	@JoinColumn(name ="VENDOR_ID")
	@ManyToOne
	private EcommerceVendor vendorId;

	@JoinColumn(name ="USER_ID")
	@ManyToOne
	private EcommerceUser userId;
	
	@Column(name ="AMOUNT")
	private BigDecimal amount;
	
	@Column(name ="TRANSACTION_ID")
	private String transactionId;
	
	@Column(name ="DESCRIPTION")
	private String description;
	
	@Column(name ="CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name ="UPDATED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public EcommerceOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public EcommerceCart getCartId() {
		return cartId;
	}

	public void setCartId(EcommerceCart cartId) {
		this.cartId = cartId;
	}

	public EcommerceVendor getVendorId() {
		return vendorId;
	}

	public void setVendorId(EcommerceVendor vendorId) {
		this.vendorId = vendorId;
	}

	public EcommerceUser getUserId() {
		return userId;
	}

	public void setUserId(EcommerceUser userId) {
		this.userId = userId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
	
	
	
}
