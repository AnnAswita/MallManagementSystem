/**
 * author : carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;


public interface DeliveryState {
    void schedule(Delivery delivery);

    void startDelivery(Delivery delivery);

    void completeDelivery(Delivery delivery);

    void cancel(Delivery delivery);

    String getStatus();
}
