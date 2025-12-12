/**
 * author: carolin.thomas
 */
package com.mall.factory;

import java.util.List;

import com.mall.model.Address;
import com.mall.model.Delivery;
import com.mall.model.Goods;
import com.mall.model.Item;


public class ExpressDeliveryFactory extends AbstractDeliveryFactory{

	@Override
	public Delivery createDelivery(Long id, Goods goods, Address address, List<Item> items, double weightKg,
			String sizeCategory) {
		Delivery d = createBaseDelivery(
	            id, goods, address, items, weightKg, sizeCategory
	        );

	        d.setType("EXPRESS");
	        d.setSummary("Priority express delivery");
	        d.setInvoice("EXP-" + id);

	        return d;
	}

}
