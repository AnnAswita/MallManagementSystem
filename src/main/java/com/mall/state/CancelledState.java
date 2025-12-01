/**
 * author: carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;

public class CancelledState  implements DeliveryState{

	@Override
	public void next(Delivery delivery) {
		System.out.println("Cancelled deliveries cannot move forward.");
		
	}

	@Override
	public void prev(Delivery delivery) {
		System.out.println("Cancelled deliveries cannot move forward.");
		
	}

	@Override
	public String getStatus() {
        return "CANCELLED";
	}

}
