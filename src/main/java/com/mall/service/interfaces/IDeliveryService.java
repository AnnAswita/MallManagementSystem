package com.mall.service.interfaces;

import com.mall.model.Delivery;
public interface IDeliveryService {
	 Delivery createDelivery(String orderDetails, String destination);
	 List<Delivery> getPendingDeliveries();
	 Delivery assignDelivery(int deliveryId, int staffId);
}
