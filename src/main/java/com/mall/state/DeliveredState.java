/**
 * author: carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;

public class DeliveredState implements DeliveryState{

	@Override
	public void next(Delivery delivery) {
        System.out.println("Already delivered. No next state.");
		
	}

	@Override
	public void prev(Delivery delivery) {
        delivery.setState(new InTransitState());		
	}

	@Override
	public String getStatus() {
        return "DELIVERED";
	}

}
