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
    public static Delivery createDelivery(Long id, Goods goods, Address address, List<Item> items) {

        Delivery d = new Delivery();

        d.setDeliveryId(id);
        d.setGoods(goods);
        d.setAddress(address);
        d.setItems(items);

        //Default Statuss
        d.setState(new PendingState());

        return d;
    }

}
