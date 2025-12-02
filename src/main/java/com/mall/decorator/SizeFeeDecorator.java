package com.mall.decorator;

public class SizeFeeDecorator extends DeliveryFeeDecorator {
   
	private final String sizeCategory;
    
	public SizeFeeDecorator(DeliveryFee fee, String sizeCategory) { 
		super(fee); 
		this.sizeCategory = sizeCategory; 
	}
	
    @Override
    public double calculateFee() {
        double extra = 0;
        if ("SMALL".equalsIgnoreCase(sizeCategory)) {
        	extra = 0;
        }
        else if ("MEDIUM".equalsIgnoreCase(sizeCategory)) {
        	extra = 10;
        }
        else if ("LARGE".equalsIgnoreCase(sizeCategory)) {
        	extra = 20;
        }
        return fee.calculateFee() + extra;
    }
}
