package com.ECommerce_Web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ECommerce_Web.Model.EcommerceCategory;


public interface EcommerceCategoryRepo extends JpaRepository<EcommerceCategory, Long>{

	EcommerceCategory findByNameAndEcommerceVendorVendorId(String name, long vendorId);

	EcommerceCategory findByCategoryId(long categoryId);

	List<EcommerceCategory> findByEcommerceVendorVendorId(long vendorId);

	

}
