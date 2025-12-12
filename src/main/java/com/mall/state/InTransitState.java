/**
 * author: carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;

public class InTransitState implements DeliveryState {

	@Override
    public void schedule(Delivery delivery) {
        throw new IllegalStateException(
            "Delivery already scheduledt"
        );
    }

    @Override
    public void startDelivery(Delivery delivery) {
        throw new IllegalStateException(
            "Delivery already started"
        );
    }

    @Override
    public void completeDelivery(Delivery delivery) {
        delivery.setState(new DeliveredState());
    }

    @Override
    public void cancel(Delivery delivery) {
        throw new IllegalStateException(
            "Cannot cancel delivery once in transit"
        );
    }

    @Override
    public String getStatus() {
        return "IN_TRANSIT";
    }

}
