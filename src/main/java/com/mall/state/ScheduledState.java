/**
 * author: carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;


public class ScheduledState implements DeliveryState{

	@Override
    public void schedule(Delivery delivery) {
        throw new IllegalStateException(
            "Delivery already scheduled"
        );
    }

    @Override
    public void startDelivery(Delivery delivery) {
        delivery.setState(new InTransitState());
    }

    @Override
    public void completeDelivery(Delivery delivery) {
        throw new IllegalStateException(
            "Delivery has not started yet"
        );
    }

    @Override
    public void cancel(Delivery delivery) {
        delivery.setState(new CancelledState());
    }

    @Override
    public String getStatus() {
        return "SCHEDULED";
    }

}
