//Author Ann Aswita
package com.mall.decorator;

public abstract class DeliveryFeeDecorator implements DeliveryFee{
	
	 protected final DeliveryFee fee;
	 
	 public DeliveryFeeDecorator(DeliveryFee fee) { 
		 this.fee = fee; 
	}
}
