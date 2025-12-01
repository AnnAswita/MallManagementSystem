/**
 * author: carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;

public class InTransitState implements DeliveryState {

	@Override
	public void next(Delivery delivery) {
		  delivery.setState(new DeliveredState());	
	}

	@Override
	public void prev(Delivery delivery) {        
		delivery.setState(new ScheduledState());
	}

	@Override
	public String getStatus() {
		return "IN_TRANSIT";
	}

}
