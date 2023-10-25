package com.ECommerce_Web.Service;

import java.util.List;

import com.ECommerce_Web.DTO.EcommerceCategoryDto;
import com.ECommerce_Web.DTO.EcommerceItemsDto;
import com.ECommerce_Web.DTO.EcommerceOrderDto;
import com.ECommerce_Web.DTO.EcommerceVendorDto;

public interface EcommerceVendorService {
	
	//Vendor Service
	
	public EcommerceVendorDto addVendor(EcommerceVendorDto ecommerceVendorDto);
	public EcommerceVendorDto updateVendor(EcommerceVendorDto ecommerceVendorDto);
	public EcommerceVendorDto getByVendorId(long vendorId);
	public EcommerceVendorDto deleteVendor(long vendorId);

	//Category Service
	
	public EcommerceCategoryDto addCategory(EcommerceCategoryDto ecommerceCategoryDto);
	public EcommerceCategoryDto getByCategoryId(long categoryId);
	public EcommerceCategoryDto updateCategory(EcommerceCategoryDto ecommerceCategoryDto);
	public List<EcommerceCategoryDto> getAllCategoryByVendor(long vendorId);
	
	//Items Service
	
	public EcommerceItemsDto addItems(EcommerceItemsDto ecommerceItemsDto);
	public EcommerceItemsDto getByItemId(long itemId);
	public EcommerceItemsDto updateItems(EcommerceItemsDto ecommerceItemsDto);
	public List<EcommerceItemsDto> getAllItemsByCategory(long categoryId);
	
	//OrderHistory Service
	
	public EcommerceOrderDto getOrderHistoryByVendorIdAndOrderId(long vendorId, long orderId);
	public List<EcommerceOrderDto> getAllOrderHistoryByVendorId(long vendorId);
	
	
}
