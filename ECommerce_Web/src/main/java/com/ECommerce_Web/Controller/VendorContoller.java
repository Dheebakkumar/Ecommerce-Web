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

import com.ECommerce_Web.DTO.EcommerceCategoryDto;
import com.ECommerce_Web.DTO.EcommerceItemsDto;
import com.ECommerce_Web.DTO.EcommerceOrderDto;
import com.ECommerce_Web.DTO.EcommerceVendorDto;
import com.ECommerce_Web.Service.EcommerceVendorService;

@RestController
@RequestMapping("/ecom/vendor")
public class VendorContoller {
	
	//VendorController
	
	@Autowired
	EcommerceVendorService ecommerceVendorService;

	@PostMapping("/add")
	public EcommerceVendorDto addVendor(@RequestBody EcommerceVendorDto ecommerceVendorDto) {
		
		return ecommerceVendorService.addVendor(ecommerceVendorDto);
	 }
	
	@PutMapping("/update")
	public EcommerceVendorDto updateVendor(@RequestBody EcommerceVendorDto ecommerceVendorDto) {
		
		return ecommerceVendorService.updateVendor(ecommerceVendorDto);
	 }

	@GetMapping("/getId/{vendorId}") 
	public EcommerceVendorDto getByVendorId(@PathVariable long vendorId) {
		
		return ecommerceVendorService.getByVendorId(vendorId);
	 }
	
	@DeleteMapping("/deleteId/{vendorId}") 
	public EcommerceVendorDto deleteVendor(@PathVariable long vendorId) {
		
		return ecommerceVendorService.deleteVendor(vendorId);
	 }

	
	//Category Controller
	
	@PostMapping("/category/add")
	public EcommerceCategoryDto addCategory(@RequestBody EcommerceCategoryDto ecommerceCategoryDto) {
	
		return ecommerceVendorService.addCategory(ecommerceCategoryDto);
	}
	
	@GetMapping("/category/getId/{categoryId}")
	public EcommerceCategoryDto getByCategoryId(@PathVariable long categoryId) {
		
		return ecommerceVendorService.getByCategoryId(categoryId);
	}
	
	@PutMapping("/category/update")
	public EcommerceCategoryDto updateCategory(@RequestBody EcommerceCategoryDto ecommerceCategoryDto) {
	
		return ecommerceVendorService.updateCategory(ecommerceCategoryDto);
	}
	
	@GetMapping("/category/getAllId/{vendorId}")
	public List<EcommerceCategoryDto> getAllCategoryByVendorId(@PathVariable long vendorId) {
		
		return ecommerceVendorService.getAllCategoryByVendor(vendorId);
	}
	
	
	//Items Controller
	
	@PostMapping("/items/add")
	public EcommerceItemsDto addItem(@RequestBody EcommerceItemsDto ecommerceItemsDto) {
		
		return ecommerceVendorService.addItems(ecommerceItemsDto);
	}
	
	@GetMapping("/items/getId/{itemId}")
	public EcommerceItemsDto getByItemId(@PathVariable long itemId) {
		
		return ecommerceVendorService.getByItemId(itemId);
	}
	
	@PutMapping("/items/update")
	public EcommerceItemsDto updateItem(@RequestBody EcommerceItemsDto ecommerceItemsDto) {
		
		return ecommerceVendorService.updateItems(ecommerceItemsDto);
	}
	
	@GetMapping("/items/getAllId/{categoryId}")
	public List<EcommerceItemsDto> getAllItemsByCategory(@PathVariable long categoryId){
		
		return ecommerceVendorService.getAllItemsByCategory(categoryId);
	}
	
	
	//OrderHistoryController
	
	@GetMapping("/orderHistory/vendorId/{vendorId}/orderId/{orderId}")
	public EcommerceOrderDto getOrderHistoryByVendorIdAndOrderId(@PathVariable long vendorId,@PathVariable long orderId) {
		
		return ecommerceVendorService.getOrderHistoryByVendorIdAndOrderId(vendorId, orderId);
	}
	
	@GetMapping("/orderHistory/getAllId/vendorId/{vendorId}")
	public List<EcommerceOrderDto> getAllOrderHistoryByVendorId(@PathVariable long vendorId) {
		
		return ecommerceVendorService.getAllOrderHistoryByVendorId(vendorId);
	}
}
