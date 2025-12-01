package com.mall.service.interfaces;

import java.util.List;

import com.mall.model.Delivery;

public interface IDeliveryService {
	
	 Delivery createDelivery(Long goodsId, Long addressId, List<Long> itemIds);
	 List<Delivery> getPendingDeliveries();
	 Delivery assignDelivery(Long deliveryId, Long staffId);
	 Delivery updateStatus(Long deliveryId);
}
