package com.mall.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mall.command.CommandInvoker;
import com.mall.command.UpdateStatusCommand;
import com.mall.service.interfaces.IDeliveryService;
import com.mall.service.interfaces.ILogisticsService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final IDeliveryService deliveryService;
   // private final ILogisticsService logisticsService;

    public DeliveryController(IDeliveryService deliveryService, ILogisticsService logisticsService) {
        this.deliveryService = deliveryService;
       // this.logisticsService = logisticsService;
    }

    @PutMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        CommandInvoker invoker = new CommandInvoker();
        invoker.addCommand(new UpdateStatusCommand(deliveryService, id));
        invoker.executeAll();
        return "OK";
    }
}
