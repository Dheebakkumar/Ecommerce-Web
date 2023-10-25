package com.ECommerce_Web.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ECommerce_Web.DTO.EcommerceAccountDto;
import com.ECommerce_Web.DTO.EcommerceCartDto;
import com.ECommerce_Web.DTO.EcommerceCartDto1;
import com.ECommerce_Web.DTO.EcommerceCategoryDto;
import com.ECommerce_Web.DTO.EcommerceItemsDto;
import com.ECommerce_Web.DTO.EcommerceOrderDto;
import com.ECommerce_Web.DTO.EcommerceUserDto;
import com.ECommerce_Web.Model.EcommerceAccount;
import com.ECommerce_Web.Model.EcommerceCart;
import com.ECommerce_Web.Model.EcommerceCategory;
import com.ECommerce_Web.Model.EcommerceItem;
import com.ECommerce_Web.Model.EcommerceOrder;
import com.ECommerce_Web.Model.EcommerceUser;
import com.ECommerce_Web.Model.EcommerceVendor;
import com.ECommerce_Web.Repository.EcommerceAccountRepo;
import com.ECommerce_Web.Repository.EcommerceCartRepo;
import com.ECommerce_Web.Repository.EcommerceCategoryRepo;
import com.ECommerce_Web.Repository.EcommerceItemsRepo;
import com.ECommerce_Web.Repository.EcommerceOrderRepo;
import com.ECommerce_Web.Repository.EcommerceUserRepo;
import com.ECommerce_Web.Repository.EcommerceVendorRepo;
import com.ECommerce_Web.Service.EcommerceUserService;

@Service
public class EcommerceUserServiceImpl implements EcommerceUserService {
	
	//Cart Service Impl
	
	@Autowired
	EcommerceItemsRepo itemsRepo;
	
	@Autowired
	EcommerceCartRepo cartRepo;
	
	@Override
	public EcommerceCartDto1 addCart(EcommerceCartDto ecommerceCartDto) {

		EcommerceCart ecommerceCart = new EcommerceCart();
		
		BigDecimal amount = new BigDecimal("0");

		List<EcommerceItem> listItems = ecommerceCartDto.getItemId();
		
		for(EcommerceItem item : listItems) {
			
			EcommerceItem checkId = itemsRepo.findByItemId(item.getItemId());
			if(checkId !=null) {
				
				long count = item.getQuantity();
				
				BigDecimal itemAmt = checkId.getAmount();
				
				if(count > 1) {
					
					itemAmt = itemAmt.multiply(BigDecimal.valueOf(count));
					
					amount = amount.add(itemAmt);
				}
				else {
					
					amount = amount.add(itemAmt);
				}
			}
			else throw new RuntimeException("Item Id is Not Present");
			
			
		}	
		
		ecommerceCart.setAmount(amount);
			
		EcommerceCart cart = cartRepo.save(ecommerceCart);
		
		return cartDto(cart);
				
	}
	
	public EcommerceCartDto1 cartDto(EcommerceCart cart) {
		
		EcommerceCartDto1 dto = new EcommerceCartDto1();
		
		dto.setCartId(cart.getCartId());
		dto.setAmount(cart.getAmount());
		
		return dto;
		
	}

	@Override
	public EcommerceCartDto1 updateCart(EcommerceCartDto ecommerceCartDto) {

		EcommerceCart checkId = cartRepo.findByCartId(ecommerceCartDto.getCartId());
		if(checkId !=null) {
			
			
			BigDecimal amount = new BigDecimal("0");

			List<EcommerceItem> listItems = ecommerceCartDto.getItemId();
			
			for(EcommerceItem item : listItems) {
				
				EcommerceItem checkItem = itemsRepo.findByItemId(item.getItemId());
				if(checkItem !=null) {
					
					long count = item.getQuantity();
					
					BigDecimal itemAmt = checkItem.getAmount();
					
					if(count > 1) {
						
						itemAmt = itemAmt.multiply(BigDecimal.valueOf(count));
						
						amount = amount.add(itemAmt);
					}
					else {
						 
						amount = amount.add(itemAmt);
					}
				}
				else throw new RuntimeException("Item Id is Not Present");
				
			}
			
			checkId.setAmount(amount);
			EcommerceCart cart = cartRepo.save(checkId);
			
			return cartDto(cart);
			
		}
		else throw new RuntimeException("Item Id is Not Present");	
	}
	
	public Object deleteCart(long cartId) {
		
		EcommerceCart checkId = cartRepo.findByCartId(cartId);
		if(checkId !=null) {
			
			cartRepo.delete(checkId);
			
			Map<String,String> map = new HashMap<String,String>();
			map.put(" Status ", " Deleted Successfully ");
			
			return map;
			
		}
		else {
			
			Map<String,String> map = new HashMap<String,String>();
			map.put(" Message ", " Account Id is Not Present ");
			
			return map;

		}

	}
	
	
	//User Service Impl

	@Autowired
	EcommerceUserRepo userRepo;
	
	
	@Override
	public EcommerceUserDto addUser(EcommerceUserDto ecommerceUserDto) {
		
		EcommerceUser checkMail = userRepo.findByEmailId(ecommerceUserDto.getEmailId());
		if(checkMail == null) {
			
			EcommerceUser checkNum = userRepo.findByMobileNumber(ecommerceUserDto.getMobileNumber());
			if(checkNum == null) {
				
				EcommerceUser ecommerceUser = new EcommerceUser();
				
				ecommerceUser.setName(ecommerceUserDto.getName());
				ecommerceUser.setDob(ecommerceUserDto.getDob());
				ecommerceUser.setGender(ecommerceUserDto.getGender());
				ecommerceUser.setEmailId(ecommerceUserDto.getEmailId());
				ecommerceUser.setMobileNumber(ecommerceUserDto.getMobileNumber());
				ecommerceUser.setBalance(new BigDecimal(1000));
				
				EcommerceUser user = userRepo.save(ecommerceUser);
				
				return userDto(user);

			}
			else throw new RuntimeException("Mobile Number Should be Unique");	
		}
		else throw new RuntimeException("Email Id Should be Unique");	
		
	}
	
	
	public EcommerceUserDto userDto(EcommerceUser user) {
		
		EcommerceUserDto dto = new EcommerceUserDto();
		
		dto.setUserId(user.getUserId());
		dto.setName(user.getName());
		dto.setDob(user.getDob());
		dto.setGender(user.getGender());
		dto.setEmailId(user.getEmailId());
		dto.setMobileNumber(user.getMobileNumber());
		dto.setBalance(user.getBalance());
		dto.setCreatedOn(user.getCreatedOn());
		dto.setUpdatedOn(user.getUpdatedOn());
		
		return dto;
		
	}

	@Override
	public EcommerceUserDto getByUserId(long userId) {

		EcommerceUser checkId = userRepo.findByUserId(userId);
		if(checkId !=null) {
			
			return userDto(checkId);
		}
		else throw new RuntimeException("User Id is Not Present");	

	}

	@Override
	public EcommerceUserDto updateUser(EcommerceUserDto ecommerceUserDto) {

		EcommerceUser checkId = userRepo.findByUserId(ecommerceUserDto.getUserId());
		if(checkId !=null) {
			
			EcommerceUser checkMail = userRepo.findByEmailId(ecommerceUserDto.getEmailId());
			if(checkMail == null) {
				
				EcommerceUser checkNum = userRepo.findByMobileNumber(ecommerceUserDto.getMobileNumber());
				if(checkNum == null) {
					
						checkId.setName(ecommerceUserDto.getName());
						checkId.setEmailId(ecommerceUserDto.getEmailId());
						checkId.setDob(ecommerceUserDto.getDob());
						checkId.setGender(ecommerceUserDto.getGender());
						checkId.setMobileNumber(ecommerceUserDto.getMobileNumber());
						
						EcommerceUser user = userRepo.save(checkId);
						
						return userDto(user);
					
				}
				else throw new RuntimeException("Mobile Number Should be Unique");	
			}
			else throw new RuntimeException("Email Id Should be Unique");	
		}
		else throw new RuntimeException("User Id is Not Present");	

	}

	@Override
	public Object deleteUser(long userId) {
		
		EcommerceUser checkId = userRepo.findByUserId(userId);
		if(checkId !=null) {
			
			userRepo.delete(checkId);
			
			Map<String,String> map = new HashMap<String,String>();
			map.put(" Status ", " Deleted Successfully ");
			
			return map;
			
		}
		else {
			
			Map<String,String> map = new HashMap<String,String>();
			map.put(" Message ", " User Id is Not Present ");
			
			return map;

		}
	}

	
	//Category Service Impl
	
	@Autowired
	EcommerceCategoryRepo categoryRepo;
	
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

	@Override
	public EcommerceCategoryDto getByCategory(long categoryId) {
		
		EcommerceCategory checkId = categoryRepo.findByCategoryId(categoryId);
		if(checkId !=null) {
			
			return categoryDto(checkId);
		}
		else throw new RuntimeException("Category Id is not present");
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
	
	
	//Items Service Impl

	
	@Autowired
	EcommerceItemsRepo itemRepo;

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
	public EcommerceItemsDto getByItem(long itemId) {
		
		EcommerceItem checkId = itemRepo.findByItemId(itemId);
		if(checkId !=null) {
			
			return itemsDto(checkId);
		}
		else throw new RuntimeException("Item Id is not present");
	}
	
	
	//Order Service Impl
	
	@Autowired
	EcommerceOrderRepo orderRepo;
	
	@Autowired
	EcommerceVendorRepo vendorRepo;
	
	@Override
	public EcommerceOrderDto addOrder(EcommerceOrderDto ecommerceOrderDto) {

		EcommerceUser checkUser = userRepo.findByUserId(ecommerceOrderDto.getUserId());
		if(checkUser !=null) {
			
			EcommerceVendor checkVendor = vendorRepo.findByVendorId(ecommerceOrderDto.getVendorId());
			if(checkVendor !=null) {
				
				EcommerceCart checkCart = cartRepo.findByCartId(ecommerceOrderDto.getCartId());
				if(checkCart !=null) {
					
					BigDecimal cartAmt = checkCart.getAmount();
					
					BigDecimal userAmt = checkUser.getBalance();
					
					int value = userAmt.compareTo(cartAmt);
					
					if(value > 0) {
						
						BigDecimal balance = userAmt.subtract(cartAmt);
						
						checkUser.setBalance(balance);
						
						BigDecimal updateAmt = checkVendor.getBalance().add(cartAmt);
						
						checkVendor.setBalance(updateAmt);

						EcommerceOrder ecommerceOrder = new EcommerceOrder();
						
						ecommerceOrder.setUserId(checkUser);
						ecommerceOrder.setVendorId(checkVendor);
						ecommerceOrder.setCartId(checkCart);
						ecommerceOrder.setAmount(cartAmt);
						ecommerceOrder.setTransactionId(UUID.randomUUID().toString());
						ecommerceOrder.setDescription("Paymet Successfully");
						
						EcommerceOrder order = orderRepo.save(ecommerceOrder);
							
						return orderDto(order);
					}
					else throw new RuntimeException("Your Balance is Lessthan Total Amount");
				}
				else throw new RuntimeException("Cart Id is Not Present");
			}
			else throw new RuntimeException("Vendor Id is Not Present");
		}
		else throw new RuntimeException("User Id is Not Present");
	
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
	public EcommerceOrderDto OrderHistoryByUserIdAndOrderId(long userId, long orderId) {

		EcommerceUser checkUser = userRepo.findByUserId(userId);
		if(checkUser !=null) {
			
			EcommerceOrder checkOrder = orderRepo.findByOrderId(orderId);
			if(checkOrder !=null) {
				
				EcommerceOrder order = orderRepo.findByUserIdUserIdAndOrderId(userId,orderId);
				if(order !=null) {
					
					return orderDto(order);
				}
				else throw new RuntimeException(" No Data Exits ");
			}
			else throw new RuntimeException("Order Id is Not Present");
		}
		else throw new RuntimeException("User Id is Not Present");

	}

	@Override
	public List<EcommerceOrderDto> getAllOrderHistoryByUser(long userId) {

		EcommerceUser checkUser = userRepo.findByUserId(userId);
		if(checkUser !=null) {
			
			List<EcommerceOrder> orderList = orderRepo.findByUserIdUserId(userId);
			
			List<EcommerceOrderDto> newList = new ArrayList<EcommerceOrderDto>();
			
			for(EcommerceOrder order : orderList) {
				
				EcommerceOrderDto orders = orderDto(order);
				newList.add(orders);
			}
			return newList;
		
		}
		else throw new RuntimeException("User Id is Not Present");

	}
	
	
	//Account Service Impl
	
	@Autowired
	EcommerceAccountRepo accountRepo;

	@Override
	public EcommerceAccountDto addAccount(EcommerceAccountDto ecommerceAccountDto) {

		EcommerceUser checkUser = userRepo.findByUserId(ecommerceAccountDto.getUserId());
		if(checkUser !=null) {
			
			EcommerceItem checkItem = itemsRepo.findByItemId(ecommerceAccountDto.getItemId());
			if(checkItem !=null) {
				
				EcommerceAccount ecommerceAccount = new EcommerceAccount();
				
				ecommerceAccount.setEcommerceItem(checkItem);
				ecommerceAccount.setEcommerceUser(checkUser);
				ecommerceAccount.setItemName(checkItem.getName());
				ecommerceAccount.setAmount(checkItem.getAmount());
				ecommerceAccount.setDescription(checkItem.getDescription());
				ecommerceAccount.setStatus(checkItem.isStatus());
				
				EcommerceAccount account = accountRepo.save(ecommerceAccount);
				
				return accountDto(account);
			}
			else throw new RuntimeException("Item Id is Not Present");
		}
		else throw new RuntimeException("User Id is Not Present");
		
	}
	

	public EcommerceAccountDto accountDto(EcommerceAccount account) {
		
		EcommerceAccountDto dto = new EcommerceAccountDto();
		
		dto.setAccountId(account.getAccountId());
		dto.setItemId(account.getEcommerceItem().getItemId());
		dto.setUserId(account.getEcommerceUser().getUserId());
		dto.setItemName(account.getItemName());
		dto.setAmount(account.getAmount());
		dto.setDescription(account.getDescription());
		dto.setStatus(account.getStatus());
		
		return dto;
	}

	@Override
	public EcommerceAccountDto getByAccount(long accountId) {
		
		EcommerceAccount checkId = accountRepo.findByAccountId(accountId);
		if(checkId !=null) {
			
			return accountDto(checkId);
		}
		else throw new RuntimeException("Account Id is Not Present");

	}

	@Override
	public Object deleteAccount(long accountId) {

		EcommerceAccount checkId = accountRepo.findByAccountId(accountId);
		if(checkId !=null) {
		
			accountRepo.delete(checkId);
			
			Map<String,String> map = new HashMap<String,String>();
			map.put(" Status ", " Deleted Successfully ");
			
			return map;
			
		}
		else {
			
			Map<String,String> map = new HashMap<String,String>();
			map.put(" Message ", " Account Id is Not Present ");
			
			return map;

		}

	}
	
	
}
