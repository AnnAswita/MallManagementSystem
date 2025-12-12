//Author Ann Aswita 
package com.mall.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mall.command.CommandInvoker;
import com.mall.command.CreateDeliveryCommand;
import com.mall.model.Delivery;
import com.mall.service.interfaces.IDeliveryService;
import com.mall.service.interfaces.INotificationService;

@RestController
@RequestMapping("/shopmanager")
public class ShopManagerLogisticsController {

    private final IDeliveryService deliveryService;
    //private final INotificationService notificationService;

    public ShopManagerLogisticsController(IDeliveryService deliveryService, INotificationService notificationService) {
        this.deliveryService = deliveryService;
        //this.notificationService = notificationService;
    }

    @PostMapping("/requestDelivery")
    public Delivery requestDelivery(@RequestParam Long goodsId,@RequestParam Long addressId,@RequestParam String type,@RequestParam double weightKg, @RequestParam String sizeCategory,@RequestParam List<Long> itemIds,@RequestParam String logisticsManagerID) {
    	//IDeliveryService deliveryService,Long goodsId, Long addressId, String type, double weight, String size, List<Long> itemIds
        // Use Command pattern to create delivery
        CommandInvoker invoker = new CommandInvoker();
        CreateDeliveryCommand createCmd = new CreateDeliveryCommand(deliveryService, goodsId, addressId, type, weightKg, sizeCategory, itemIds);
        invoker.addCommand(createCmd);
        invoker.executeAll();

        // notify logistics manager (observer)
        //if (d != null) notificationService.notifyObserver(logisticsManagerID, "New Delivery Request Received: " + d.getDeliveryId());

        return createCmd.getResult();
    }
}
