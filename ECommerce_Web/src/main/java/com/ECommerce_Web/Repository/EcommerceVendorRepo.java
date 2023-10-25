package com.ECommerce_Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ECommerce_Web.Model.EcommerceVendor;

@Repository
public interface EcommerceVendorRepo extends JpaRepository<EcommerceVendor, Long> {
	
	 EcommerceVendor findByEmailId(String emailId);
	 EcommerceVendor findByMobileNumber(String mobileNumber);
	 EcommerceVendor findByVendorId(long id);
	
	
	
	
}
