/**
 * author: carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;

public class PendingState implements DeliveryState {

	@Override
	public void next(Delivery delivery) {
		delivery.setState(new ScheduledState());
		
	}

	@Override
	public void prev(Delivery delivery) {
		System.out.println("Pending is the initial state. No previous state.");
		
	}

	@Override
	public String getStatus() {
		return "PENDING";
	}

}
