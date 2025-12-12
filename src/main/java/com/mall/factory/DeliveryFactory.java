/**
 * author: carolin.thomas
 */
package com.mall.factory;

import java.util.List;

import com.mall.model.Address;
import com.mall.model.Delivery;
import com.mall.model.Goods;
import com.mall.model.Item;


public interface DeliveryFactory {
	
	  Delivery createDelivery(
	            Long id,
	            Goods goods,
	            Address address,
	            List<Item> items,
	            double weightKg,
	            String sizeCategory
	    );

}
