package com.ECommerce_Web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ECommerce_Web.Model.EcommerceItem;

public interface EcommerceItemsRepo extends JpaRepository<EcommerceItem, Long> {

	EcommerceItem findByNameAndEcommerceVendorVendorId(String name, long vendorId);

	List<EcommerceItem> findByEcommerceCategoryCategoryId(long categoryId);

	EcommerceItem findByItemId(long itemId);

}
