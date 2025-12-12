//Author Ann Aswita
package com.mall.decorator;

public class BaseDeliveryFee implements DeliveryFee{
	
	@Override
	public double calculateFee() {
		return 20.0; //base fee
	}
}
