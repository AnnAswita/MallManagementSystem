/**
 * author: carolin.thomas
 */
package com.mall.interceptor;


public class DeliveryLoggingInterceptor implements Interceptor {

	@Override
	public void intercept(DeliveryContext context) {
		System.out.println(
	            "[LOG] Staff " + context.getStaffId() +
	            " updating delivery " + context.getDelivery().getDeliveryId() +
	            " (current status: " + context.getDelivery().getStatus() + ")"
	        );	
	}

}
