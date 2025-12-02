package com.mall.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mall.command.CommandInvoker;
import com.mall.command.ScheduleDeliveryCommand;
import com.mall.model.Delivery;
import com.mall.service.interfaces.ILogisticsService;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {

    private final ILogisticsService logisticsService;

    public LogisticsController(ILogisticsService logisticsService) { this.logisticsService = logisticsService; }

    @GetMapping("/pending")
    public List<Delivery> pending() { return logisticsService.getPendingDeliveries(); }

    @PostMapping("/schedule")
    public Delivery schedule(@RequestParam Long deliveryId, @RequestParam Long staffId) {
        CommandInvoker invoker = new CommandInvoker();
        ScheduleDeliveryCommand cmd = new ScheduleDeliveryCommand(logisticsService, deliveryId, staffId);
        invoker.addCommand(cmd);
        invoker.executeAll();
        
        return cmd.getResult();
    }
}
