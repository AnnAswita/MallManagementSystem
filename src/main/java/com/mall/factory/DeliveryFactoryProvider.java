/**
 * author: carolin.thomas
 */
package com.mall.factory;

/**
 * 
 */
public class DeliveryFactoryProvider {
	
	 public static DeliveryFactory getFactory(String type) {

	        if ("EXPRESS".equalsIgnoreCase(type)) {
	            return new ExpressDeliveryFactory();
	        }

	        return new NormalDeliveryFactory();
	    }

}
