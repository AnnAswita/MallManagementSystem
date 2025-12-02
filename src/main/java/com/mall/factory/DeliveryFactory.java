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


public class DeliveryFactory {
    public static Delivery createDelivery(Long id, Goods goods, Address address, List<Item> items, String type, double weightKg, String sizeCategory) {

        Delivery d = new Delivery();

        d.setDeliveryId(id);
        d.setGoods(goods);
        d.setAddress(address);
        d.setItems(items);
        d.setType(type);
        d.setWeight(weightKg);
        d.setSizeCategory(sizeCategory);
        //Default Status
        d.setState(new PendingState());

        return d;
    }

}
