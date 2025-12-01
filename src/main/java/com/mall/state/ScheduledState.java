/**
 * author: carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;


public class ScheduledState implements DeliveryState{

	@Override
	public void next(Delivery delivery) {
		delivery.setState(new InTransitState());
		
	}

	@Override
	public void prev(Delivery delivery) {
		 delivery.setState(new PendingState());	
	}

	@Override
	public String getStatus() {
        return "SCHEDULED";
	}

}
