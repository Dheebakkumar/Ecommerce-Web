    package com.ECommerce_Web.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ECommerce_Web.DTO.EcommerceCategoryDto;
import com.ECommerce_Web.DTO.EcommerceItemsDto;
import com.ECommerce_Web.DTO.EcommerceOrderDto;
import com.ECommerce_Web.DTO.EcommerceVendorDto;
import com.ECommerce_Web.Model.EcommerceCategory;
import com.ECommerce_Web.Model.EcommerceItem;
import com.ECommerce_Web.Model.EcommerceOrder;
import com.ECommerce_Web.Model.EcommerceVendor;
import com.ECommerce_Web.Repository.EcommerceCategoryRepo;
import com.ECommerce_Web.Repository.EcommerceItemsRepo;
import com.ECommerce_Web.Repository.EcommerceOrderRepo;
import com.ECommerce_Web.Repository.EcommerceVendorRepo;
import com.ECommerce_Web.Service.EcommerceVendorService;

@Service
public class EcommerceVendorServiceImpl implements EcommerceVendorService {
	
	//Vendor Service Impl
	
	@Autowired
	EcommerceVendorRepo vendorRepo;

	@Override
	public EcommerceVendorDto addVendor(EcommerceVendorDto ecommerceVendorDto) {

		EcommerceVendor checkEmail = vendorRepo.findByEmailId(ecommerceVendorDto.getEmailId());
		if(checkEmail ==null) {
			
			EcommerceVendor checknumber = vendorRepo.findByMobileNumber(ecommerceVendorDto.getMobileNumber());
			if(checknumber ==null) {
				
				EcommerceVendor vendor = new EcommerceVendor();
				
				vendor.setName(ecommerceVendorDto.getName());
				vendor.setMobileNumber(ecommerceVendorDto.getMobileNumber());
				vendor.setEmailId(ecommerceVendorDto.getEmailId());
				vendor.setAddress(ecommerceVendorDto.getAddress());
				vendor.setBalance(new BigDecimal(0));
				vendor.setAvailability(ecommerceVendorDto.getAvailability());
				vendor.setStatus(true);
				
				EcommerceVendor Evendor = vendorRepo.save(vendor);
				
				return vendorDto(Evendor);
						
			}
			else throw new RuntimeException("Mobile Number should be Unique");
		}
		
		else throw new RuntimeException("Email Id should be Unique");
	}
	
	public EcommerceVendorDto vendorDto(EcommerceVendor ecommerceVendor) {
		
		EcommerceVendorDto dto = new EcommerceVendorDto();
		dto.setVendorId(ecommerceVendor.getVendorId());
		dto.setName(ecommerceVendor.getName());
		dto.setMobileNumber(ecommerceVendor.getMobileNumber());
		dto.setEmailId(ecommerceVendor.getEmailId());
		dto.setAddress(ecommerceVendor.getAddress());
		dto.setBalance(ecommerceVendor.getBalance());
		dto.setAvailability(ecommerceVendor.getAvailability());
		dto.setStatus(ecommerceVendor.getStatus());
		dto.setCreatedOn(ecommerceVendor.getCreatedOn());
		dto.setUpdatedOn(ecommerceVendor.getUpdatedOn());
		
		return dto;
	}

	@Override
	public EcommerceVendorDto updateVendor(EcommerceVendorDto ecommerceVendorDto) {

		EcommerceVendor checkId = vendorRepo.findByVendorId(ecommerceVendorDto.getVendorId());
		if(checkId !=null) {
			
			EcommerceVendor checkEmail = vendorRepo.findByEmailId(ecommerceVendorDto.getEmailId());
			if(checkEmail ==null) {
				
				EcommerceVendor checknumber = vendorRepo.findByMobileNumber(ecommerceVendorDto.getMobileNumber());
				if(checknumber ==null) {
					
					checkId.setName(ecommerceVendorDto.getName());
					checkId.setMobileNumber(ecommerceVendorDto.getMobileNumber());
					checkId.setEmailId(ecommerceVendorDto.getEmailId());
					checkId.setAddress(ecommerceVendorDto.getAddress());
					checkId.setAvailability(ecommerceVendorDto.getAvailability());
					checkId.setBalance(new BigDecimal(0));

					EcommerceVendor eVendor = vendorRepo.save(checkId);
					
					return vendorDto(eVendor);
				}
				else throw new RuntimeException("Mobile Number should be Unique");
			}
			else throw new RuntimeException("Email Id should be Unique");
		}
		else throw new RuntimeException("Vendor Id is not present");
	} 

	@Override
	public EcommerceVendorDto getByVendorId(long vendorId) {

		
		EcommerceVendor checkId = vendorRepo.findByVendorId(vendorId);
		if(checkId !=null) {
			
			return vendorDto(checkId);
		}
		else throw new RuntimeException("Vendor Id is not present");
	}

	@Override
	public EcommerceVendorDto deleteVendor(long vendorId) {

		EcommerceVendor checkId = vendorRepo.findByVendorId(vendorId);
		if(checkId !=null) {
						
			checkId.setStatus(false);
			checkId.setAvailability("NO");
			
			EcommerceVendor vendor = vendorRepo.save(checkId);
			
			return vendorDto(vendor);
		}
		else throw new RuntimeException("Vendor Id is not present");
		
	}
	
	//Category Service Impl
	
	@Autowired
	EcommerceCategoryRepo categoryRepo;

	@Override
	public EcommerceCategoryDto addCategory(EcommerceCategoryDto ecommerceCategoryDto) {
		
		EcommerceVendor checkId = vendorRepo.findByVendorId(ecommerceCategoryDto.getVendorId());
		if(checkId !=null) {
			
			EcommerceCategory checkName = categoryRepo.findByNameAndEcommerceVendorVendorId(ecommerceCategoryDto.getName(),ecommerceCategoryDto.getVendorId());
			if(checkName ==null) {
			
				EcommerceCategory ecommerceCategory = new EcommerceCategory();
				
				ecommerceCategory.setName(ecommerceCategoryDto.getName());
				ecommerceCategory.setEcommerceVendor(checkId);
				
				EcommerceCategory category = categoryRepo.save(ecommerceCategory);
				
				return categoryDto(category);
				
			}
			else throw new RuntimeException("Category Name is Should be Unique");

		}
		else throw new RuntimeException("Vendor Id is not present");
		

	}
	
	public EcommerceCategoryDto categoryDto(EcommerceCategory category) {
		
		EcommerceCategoryDto dto = new EcommerceCategoryDto();
		
		dto.setCategoryId(category.getCategoryId());
		dto.setName(category.getName());
		dto.setVendorId(category.getEcommerceVendor().getVendorId());
		dto.setCreatedOn(category.getCreatedOn());
		dto.setUpdatedOn(category.getUpdatedOn());
		
		return dto;
	}

	@Override
	public EcommerceCategoryDto getByCategoryId(long categoryId) {

		EcommerceCategory checkId = categoryRepo.findByCategoryId(categoryId);
		if(checkId !=null) {
			
			return categoryDto(checkId);
		}
		else throw new RuntimeException("Category Id is not present");
				
	}

	@Override
	public EcommerceCategoryDto updateCategory(EcommerceCategoryDto ecommerceCategoryDto) {

		EcommerceCategory checkId = categoryRepo.findByCategoryId(ecommerceCategoryDto.getCategoryId());
		if(checkId !=null) {
			
			EcommerceCategory checkName = categoryRepo.findByNameAndEcommerceVendorVendorId(ecommerceCategoryDto.getName(),checkId.getEcommerceVendor().getVendorId());
			if(checkName ==null) {
				
				checkId.setCategoryId(ecommerceCategoryDto.getCategoryId());
				checkId.setName(ecommerceCategoryDto.getName());
				
				EcommerceCategory category = categoryRepo.save(checkId);
				
				return categoryDto(category);
			}
			else throw new RuntimeException("Category Name should be Unique");
		}
		else throw new RuntimeException("Category Id is not present");

	}

	@Override
	public List<EcommerceCategoryDto> getAllCategoryByVendor(long vendorId) {

		EcommerceVendor checkId = vendorRepo.findByVendorId(vendorId);
		if(checkId !=null) {
			
			List<EcommerceCategory> categoryList = categoryRepo.findByEcommerceVendorVendorId(vendorId);
			
			List<EcommerceCategoryDto> newList = new ArrayList<EcommerceCategoryDto>();
			
			for(EcommerceCategory category : categoryList) {
				
				EcommerceCategoryDto cat = categoryDto(category);
				
				newList.add(cat);
			}
			
			return newList;
			
		}
		else throw new RuntimeException("Vendor Id is not present");
		
	}

	//Items Service Impl
	
	@Autowired
	EcommerceItemsRepo itemRepo;
	
	@Override
	public EcommerceItemsDto addItems(EcommerceItemsDto ecommerceItemsDto) {
		
		
			
			EcommerceCategory checkCategory = categoryRepo.findByCategoryId(ecommerceItemsDto.getCategoryId());
			if(checkCategory !=null) {
				
 	  			EcommerceItem checkName = itemRepo.findByNameAndEcommerceVendorVendorId(ecommerceItemsDto.getName(),checkCategory.getEcommerceVendor().getVendorId());
				if(checkName == null) {
					
					EcommerceItem ecommerceItem = new EcommerceItem();
					
					ecommerceItem.setEcommerceVendor(checkCategory.getEcommerceVendor());
					ecommerceItem.setEcommerceCategory(checkCategory);
					ecommerceItem.setName(ecommerceItemsDto.getName());
					ecommerceItem.setQuantity(0);
					ecommerceItem.setStatus(true);
					ecommerceItem.setDescription(ecommerceItemsDto.getDescription());
					ecommerceItem.setAmount(ecommerceItemsDto.getAmount());
					
					EcommerceItem item = itemRepo.save(ecommerceItem);
					
					return itemsDto(item);
					
				}
				else throw new RuntimeException("Item Name Should be Unique");
			}
			else throw new RuntimeException("Category Id is not present");
		
		
		
	}

	public EcommerceItemsDto itemsDto(EcommerceItem item) {
		
		EcommerceItemsDto dto = new EcommerceItemsDto();
		
		dto.setItemId(item.getItemId());
		dto.setVendorId(item.getEcommerceVendor().getVendorId());
		dto.setCategoryId(item.getEcommerceCategory().getCategoryId());
		dto.setName(item.getName());
		dto.setAmount(item.getAmount());
		dto.setDescription(item.getDescription());
		dto.setStatus(item.isStatus());
		dto.setCreatedOn(item.getCreatedOn());
		dto.setUpdatedOn(item.getUpdatedOn());
		
		return dto;
	}

	@Override
	public EcommerceItemsDto getByItemId(long itemId) {

		EcommerceItem checkId = itemRepo.findByItemId(itemId);
		if(checkId !=null) {
			
			return itemsDto(checkId);
		}
		else throw new RuntimeException("Item Id is not present");
		
	}

	@Override
	public EcommerceItemsDto updateItems(EcommerceItemsDto ecommerceItemsDto) {

		EcommerceItem checkId = itemRepo.findByItemId(ecommerceItemsDto.getItemId());
		if(checkId !=null) {
			
			EcommerceItem checkName = itemRepo.findByNameAndEcommerceVendorVendorId(ecommerceItemsDto.getName(),checkId.getEcommerceVendor().getVendorId());
			if(checkName == null) {
			
				checkId.setName(ecommerceItemsDto.getName());
				checkId.setAmount(ecommerceItemsDto.getAmount());
				checkId.setDescription(ecommerceItemsDto.getDescription());
				checkId.setStatus(ecommerceItemsDto.isStatus());
				
				EcommerceItem item = itemRepo.save(checkId);
				
				return itemsDto(item);
			}
			else throw new RuntimeException("Item Name Should be Unique");
		}
		else throw new RuntimeException("Item Id is not Present");
		
	}

	@Override
	public List<EcommerceItemsDto> getAllItemsByCategory(long categoryId) {
		
		EcommerceCategory checkId = categoryRepo.findByCategoryId(categoryId);
		if(checkId !=null) {
			
			List<EcommerceItem> ecommerceItem = itemRepo.findByEcommerceCategoryCategoryId(categoryId);
			
			List<EcommerceItemsDto> newList = new ArrayList<EcommerceItemsDto>();
			
			for(EcommerceItem item : ecommerceItem) {
				
				EcommerceItemsDto addItems = itemsDto(item);
				
				newList.add(addItems);
				
			}
			return newList;
		}
		else throw new RuntimeException("Category Id is not Present");	
		
	}
	
	//OrderHistory Service Impl
	
	
	@Autowired
	EcommerceOrderRepo orderRepo;

	@Override
	public EcommerceOrderDto getOrderHistoryByVendorIdAndOrderId(long vendorId, long orderId) {

		EcommerceVendor checkVendor = vendorRepo.findByVendorId(vendorId);
		if(checkVendor !=null) {
			
			EcommerceOrder checkOrder = orderRepo.findByOrderId(orderId);
			if(checkOrder !=null) {
				
				EcommerceOrder order = orderRepo.findByVendorIdVendorIdAndOrderId(vendorId,orderId);
				if(order !=null) {
					
					return orderDto(order);
				}
				else throw new RuntimeException("No Data Exits");	
			}
			else throw new RuntimeException("Order Id is not Present");	
		}
		else throw new RuntimeException("Vendor Id is not Present");	
	}
	
	public EcommerceOrderDto orderDto(EcommerceOrder order) {
		
		EcommerceOrderDto dto = new EcommerceOrderDto();
		
		dto.setOrderId(order.getOrderId());
		dto.setUserId(order.getUserId().getUserId());
		dto.setVendorId(order.getVendorId().getVendorId());
		dto.setCartId(order.getCartId().getCartId());
		dto.setAmount(order.getAmount());
		dto.setTransactionId(order.getTransactionId());
		dto.setDescription(order.getDescription());
		dto.setCreatedOn(order.getCreatedOn());
		dto.setUpdatedOn(order.getUpdatedOn());
		
		return dto;
				
	}

	@Override
	public List<EcommerceOrderDto> getAllOrderHistoryByVendorId(long vendorId) {

		EcommerceVendor checkId = vendorRepo.findByVendorId(vendorId);
		if(checkId !=null) {
			
			List<EcommerceOrder> orderList = orderRepo.findByVendorIdVendorId(vendorId);
			
			List<EcommerceOrderDto> newList = new ArrayList<EcommerceOrderDto>();
			
			for(EcommerceOrder order : orderList) {
				
				EcommerceOrderDto orders = orderDto(order);
				newList.add(orders);
			}
			
			return newList;
		}
		else throw new RuntimeException("Vendor Id is not Present");
		
	}

	
	
	
	
	
}
