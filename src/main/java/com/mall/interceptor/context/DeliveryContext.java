//Author Ann Aswita
package com.mall.interceptor.context;

import com.mall.model.Delivery;

public class DeliveryContext {

	private final Delivery delivery;
	private final Long staffId;
	
	public DeliveryContext(Delivery delivery, Long staffId) {
	this.delivery = delivery;
	this.staffId = staffId;
	}
	
	public Delivery getDelivery() {
	return delivery;
	}
	
	public Long getStaffId() {
	return staffId;
	}
}
