//Author Ann Aswita 
package com.mall.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mall.command.CommandInvoker;
import com.mall.command.UpdateStatusCommand;
import com.mall.model.Delivery;
import com.mall.service.interfaces.IDeliveryService;
import com.mall.service.interfaces.ILogisticsService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final IDeliveryService deliveryService;
   // private final ILogisticsService logisticsService;

    public DeliveryController(IDeliveryService deliveryService) {
        this.deliveryService = deliveryService;
       // this.logisticsService = logisticsService;
    }


    @PutMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam String status,@RequestParam Long staffId) {
        CommandInvoker invoker = new CommandInvoker();
        UpdateStatusCommand cmd = new UpdateStatusCommand(deliveryService, id,staffId);
        invoker.addCommand(cmd);
        invoker.executeAll();
        return "OK";
    }
    
    @PutMapping("/{id}/cancel")
    public String cancel(@PathVariable Long id,
                         @RequestParam Long staffId) {

        deliveryService.cancelDelivery(id, staffId);
        return "CANCELLED";
    }

}
