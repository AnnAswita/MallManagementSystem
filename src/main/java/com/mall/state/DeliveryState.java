/**
 * author : carolin.thomas
 */
package com.mall.state;

import com.mall.model.Delivery;


public interface DeliveryState {
	    void next(Delivery delivery);
	    void prev(Delivery delivery);
	    String getStatus();

}
