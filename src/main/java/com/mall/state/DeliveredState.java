/**
 * author: carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;

public class DeliveredState implements DeliveryState{

	@Override
    public void schedule(Delivery delivery) {
        throw new IllegalStateException(
            "Delivered delivery cannot be rescheduled"
        );
    }

    @Override
    public void startDelivery(Delivery delivery) {
        throw new IllegalStateException(
            "Delivery already completed"
        );
    }

    @Override
    public void completeDelivery(Delivery delivery) {
        throw new IllegalStateException(
            "Delivery already completed"
        );
    }

    @Override
    public void cancel(Delivery delivery) {
        throw new IllegalStateException(
            "Delivered delivery cannot be cancelled"
        );
    }

    @Override
    public String getStatus() {
        return "DELIVERED";
    }
}
