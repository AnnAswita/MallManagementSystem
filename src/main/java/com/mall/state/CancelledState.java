/**
 * author: carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;

public class CancelledState  implements DeliveryState{

	@Override
    public void schedule(Delivery delivery) {
        throw new IllegalStateException(
            "Cancelled delivery cannot be rescheduled"
        );
    }

    @Override
    public void startDelivery(Delivery delivery) {
        throw new IllegalStateException(
            "Cancelled delivery cannot be started"
        );
    }

    @Override
    public void completeDelivery(Delivery delivery) {
        throw new IllegalStateException(
            "Cancelled delivery cannot be completed"
        );
    }

    @Override
    public void cancel(Delivery delivery) {
        throw new IllegalStateException(
            "Delivery already cancelled"
        );
    }

    @Override
    public String getStatus() {
        return "CANCELLED";
    }

}
