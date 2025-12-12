package com.mall.service.interfaces;

import java.util.List;

import com.mall.model.Delivery;

public interface IDeliveryService {
	
	 Delivery createDelivery(Long goodsId, Long addressId, String type, double weight, String sizeCategory, List<Long> itemIds);
	 Delivery getDelivery(Long deliveryID);
	 List<Delivery> getPendingDeliveries();
	 Delivery assignDelivery(Long deliveryId, Long staffId);
	 Delivery updateStatus(Long deliveryId, Long staffId);
	 Delivery cancelDelivery(Long deliveryId, Long staffId);
}
