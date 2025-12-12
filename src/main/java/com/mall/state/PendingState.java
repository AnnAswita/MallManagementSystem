/**
 * author: carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;

public class PendingState implements DeliveryState {

	@Override
    public void schedule(Delivery delivery) {
        delivery.setState(new ScheduledState());
    }

    @Override
    public void startDelivery(Delivery delivery) {
        throw new IllegalStateException(
            "Delivery must be scheduled before starting"
        );
    }

    @Override
    public void completeDelivery(Delivery delivery) {
        throw new IllegalStateException(
            "Cannot complete delivery in Pending state"
        );
    }

    @Override
    public void cancel(Delivery delivery) {
        delivery.setState(new CancelledState());
    }

    @Override
    public String getStatus() {
        return "PENDING";
    }

}
