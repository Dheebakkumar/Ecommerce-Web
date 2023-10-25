package com.ECommerce_Web.Service;

import java.util.List;

import com.ECommerce_Web.DTO.EcommerceAccountDto;
import com.ECommerce_Web.DTO.EcommerceCartDto;
import com.ECommerce_Web.DTO.EcommerceCartDto1;
import com.ECommerce_Web.DTO.EcommerceCategoryDto;
import com.ECommerce_Web.DTO.EcommerceItemsDto;
import com.ECommerce_Web.DTO.EcommerceOrderDto;
import com.ECommerce_Web.DTO.EcommerceUserDto;

public interface EcommerceUserService {

	//Cart Service
	
	public EcommerceCartDto1 addCart(EcommerceCartDto ecommerceCartDto);
	public EcommerceCartDto1 updateCart(EcommerceCartDto ecommerceCartDto);
	public Object deleteCart(long cartId);
	
	//User Service
	
	public EcommerceUserDto addUser(EcommerceUserDto ecommerceUserDto);
	public EcommerceUserDto getByUserId(long userId);
	public EcommerceUserDto updateUser(EcommerceUserDto ecommerceUserDto);
	public Object deleteUser(long userId); 
	
	//Category Service
	
	public List<EcommerceCategoryDto> getAllCategoryByVendor(long vendorId);
	public EcommerceCategoryDto getByCategory(long categoryId);
	
	//Items Service
	
	public List<EcommerceItemsDto> getAllItemsByCategory(long categoryId);
	public EcommerceItemsDto getByItem(long itemId);
	
	
	//Order Service
	
	public EcommerceOrderDto addOrder(EcommerceOrderDto ecommerceOrderDto);
	public EcommerceOrderDto OrderHistoryByUserIdAndOrderId(long userId, long orderId);
	public List<EcommerceOrderDto> getAllOrderHistoryByUser(long userId);
	
	
	//User Account Service
	
	public EcommerceAccountDto addAccount(EcommerceAccountDto ecommerceAccountDto);
	public EcommerceAccountDto getByAccount(long accountId);
	public Object deleteAccount(long accountId);
	
}
