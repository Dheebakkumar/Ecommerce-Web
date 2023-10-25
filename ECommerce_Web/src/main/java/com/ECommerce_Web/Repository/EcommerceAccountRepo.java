package com.ECommerce_Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ECommerce_Web.Model.EcommerceAccount;

public interface EcommerceAccountRepo  extends JpaRepository<EcommerceAccount, Long>{

	EcommerceAccount findByAccountId(long accountId);

}
