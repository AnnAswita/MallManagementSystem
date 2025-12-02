package com.mall.decorator;

public class ExpressDeliveryFee extends DeliveryFeeDecorator{
	
	public ExpressDeliveryFee(DeliveryFee fee) { 
		 super(fee); 
	}
	 
   	@Override 
    public double calculateFee() { 
    	return fee.calculateFee() + 30.0; 
    }

}
