package com.ECommerce_Web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ECommerce_Web.DTO.EcommerceOrderDto;
import com.ECommerce_Web.Model.EcommerceOrder;

public interface EcommerceOrderRepo extends JpaRepository<EcommerceOrder, Long>{

	EcommerceOrder findByOrderId(long orderId);

	EcommerceOrder findByUserIdUserIdAndOrderId(long userId, long orderId);

	List<EcommerceOrder> findByUserIdUserId(long userId);

	EcommerceOrder findByVendorIdVendorIdAndOrderId(long vendorId, long orderId);

	List<EcommerceOrder> findByVendorIdVendorId(long vendorId);

}
