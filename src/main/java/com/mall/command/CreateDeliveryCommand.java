package com.mall.command;

import java.util.List;

import com.mall.model.Delivery;
import com.mall.service.interfaces.IDeliveryService;

public class CreateDeliveryCommand implements Command {

    private final IDeliveryService deliveryService;
    private final Long goodsId, addressId;
    private final String type;
    private final double weight; 
    private final String size;
    private final List<Long> itemIds;

    public CreateDeliveryCommand(IDeliveryService deliveryService,Long goodsId, Long addressId, String type, double weight, String size, List<Long> itemIds) {
        this.deliveryService = deliveryService;
        this.goodsId = goodsId;
        this.addressId = addressId;
        this.type = type;  
        this.weight = weight; 
        this.size = size;
        this.itemIds = itemIds;
    }

    @Override
    public void execute() {
        Delivery d = deliveryService.createDelivery(goodsId, addressId, type, weight, size, itemIds);
        System.out.println("[CMD] Created delivery " + d.getDeliveryId());
    }
}
