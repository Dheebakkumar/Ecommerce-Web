package com.ECommerce_Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ECommerce_Web.Model.EcommerceCart;

public interface EcommerceCartRepo extends JpaRepository<EcommerceCart, Long> {

	EcommerceCart findByCartId(long cartId);

}
