/**
 * author: carolin.thomas
 */
package com.mall.factory;

import java.util.List;

import com.mall.model.Address;
import com.mall.model.Delivery;
import com.mall.model.Goods;
import com.mall.model.Item;
import com.mall.state.PendingState;


public abstract class AbstractDeliveryFactory implements DeliveryFactory {
	
	protected Delivery createBaseDelivery(
            Long id,
            Goods goods,
            Address address,
            List<Item> items,
            double weightKg,
            String sizeCategory
    ) {
        Delivery d = new Delivery();

        d.setDeliveryId(id);
        d.setGoods(goods);
        d.setAddress(address);
        d.setItems(items);
        d.setWeight(weightKg);
        d.setSizeCategory(sizeCategory);

        d.setState(new PendingState());

        return d;
    }

}
