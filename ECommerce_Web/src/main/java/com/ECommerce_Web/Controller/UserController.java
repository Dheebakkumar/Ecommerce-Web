package com.ECommerce_Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce_Web.DTO.EcommerceAccountDto;
import com.ECommerce_Web.DTO.EcommerceCartDto;
import com.ECommerce_Web.DTO.EcommerceCartDto1;
import com.ECommerce_Web.DTO.EcommerceCategoryDto;
import com.ECommerce_Web.DTO.EcommerceItemsDto;
import com.ECommerce_Web.DTO.EcommerceOrderDto;
import com.ECommerce_Web.DTO.EcommerceUserDto;
import com.ECommerce_Web.Service.EcommerceUserService;

@RestController
@RequestMapping("/ecom/user")
public class UserController {

	@Autowired          
	EcommerceUserService ecommerceUserService;
	
	// Cart Controller
	
	@PostMapping("/cart/add")
	public EcommerceCartDto1 addCart(@RequestBody EcommerceCartDto ecommerceCartDto) {
		
		return ecommerceUserService.addCart(ecommerceCartDto);
	}
	
	@PutMapping("/cart/update")
	public EcommerceCartDto1 addUpdate(@RequestBody EcommerceCartDto ecommerceCartDto) {
		
		return ecommerceUserService.updateCart(ecommerceCartDto);
	} 
	
	@DeleteMapping("/cart/delete/id/{cartId}")
	public Object deleteCart(@PathVariable long cartId) {
		
		return ecommerceUserService.deleteCart(cartId);
	}
	
	//User Controller
	
	@PostMapping("/add")
	public EcommerceUserDto addUser(@RequestBody EcommerceUserDto ecommerceUserDto) {
		
		return ecommerceUserService.addUser(ecommerceUserDto);
	}
	
	@GetMapping("/getId/{userId}")
	public EcommerceUserDto getByUserId(@PathVariable long userId) {
		
		return ecommerceUserService.getByUserId(userId);
	}
	
	@PutMapping("/update")
	public EcommerceUserDto updateUser(@RequestBody EcommerceUserDto ecommerceUserDto) {
		
		return ecommerceUserService.updateUser(ecommerceUserDto);
	}
	
	@DeleteMapping("/delete/id/{userId}")
	public Object deleteUser(@PathVariable long userId) {
		
		return ecommerceUserService.deleteUser(userId);
	}
	
	//Category Controller
	
	@GetMapping("/category/getId/{categoryId}")
	public EcommerceCategoryDto getByCategory(@PathVariable long categoryId) {
	
		return ecommerceUserService.getByCategory(categoryId);
	}
	
	@GetMapping("/category/getAllId/{vendorId}")
	public List<EcommerceCategoryDto> getAllCategoryByVendor(@PathVariable long vendorId) {
	
		return ecommerceUserService.getAllCategoryByVendor(vendorId);
	}
	
	
	//Items Controller
	
	@GetMapping("/items/getId/{itemId}")
	public EcommerceItemsDto getByItem(@PathVariable long itemId) {
	
		return ecommerceUserService.getByItem(itemId);
	}
	
	@GetMapping("/items/getAllId/{categoryId}")
	public List<EcommerceItemsDto> getAllItemByCategory(@PathVariable long categoryId) {
	
		return ecommerceUserService.getAllItemsByCategory(categoryId); 
	}
	
	
	//Order Controller
	
	@PostMapping("/order/add")
	public EcommerceOrderDto addOrder(@RequestBody EcommerceOrderDto ecommerceOrderDto) {
		
		return ecommerceUserService.addOrder(ecommerceOrderDto);
	}
	
	@GetMapping("/order/history/userId/{userId}/orderId/{orderId}")
	public EcommerceOrderDto getOrderHistoryByUserIdAndOrderId(@PathVariable long userId ,@PathVariable long orderId) {
		
		return ecommerceUserService.OrderHistoryByUserIdAndOrderId(userId, orderId);
	}
	
	@GetMapping("/order/history/getAllId/userId/{userId}")
	public List<EcommerceOrderDto> getAllOrderHistoryByUserId(@PathVariable long userId ) {
		
		return ecommerceUserService.getAllOrderHistoryByUser(userId);
	}
								 										
	
	//Account Controller
	
	@PostMapping("/account/add")
	public EcommerceAccountDto addAccount(@RequestBody EcommerceAccountDto ecommerceAccountDto) {
		
		return ecommerceUserService.addAccount(ecommerceAccountDto);
	}
	
	@GetMapping("/account/getId/{accountId}")
	public EcommerceAccountDto getByAccountId(@PathVariable long accountId) {
		
		return ecommerceUserService.getByAccount(accountId);
	}
	   
	@DeleteMapping("/account/delete/id/{accountId}")
	public Object deleteAccount(@PathVariable long accountId) {
		
		return ecommerceUserService.deleteAccount(accountId);
	}
}
