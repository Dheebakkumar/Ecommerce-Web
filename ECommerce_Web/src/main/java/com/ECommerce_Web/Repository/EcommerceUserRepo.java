package com.ECommerce_Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ECommerce_Web.Model.EcommerceUser;

public interface EcommerceUserRepo extends JpaRepository<EcommerceUser, Long> {

	EcommerceUser findByEmailId(String emailId);

	EcommerceUser findByMobileNumber(String mobileNumber);

	EcommerceUser findByUserId(long userId);

}
