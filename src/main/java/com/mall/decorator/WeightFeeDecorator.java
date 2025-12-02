package com.mall.decorator;

public class WeightFeeDecorator extends DeliveryFeeDecorator {
    
	private final double weightKg;
    
	public WeightFeeDecorator(DeliveryFee fee, double weightKg) { 
		super(fee); 
		this.weightKg = weightKg; 
	}
	
    @Override 
    public double calculateFee() { 
    	return fee.calculateFee() + (weightKg * 5.0); 
    }
}