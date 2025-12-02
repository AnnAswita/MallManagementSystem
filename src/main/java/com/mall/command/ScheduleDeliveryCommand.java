package com.mall.command;

import com.mall.model.Delivery;
import com.mall.service.interfaces.ILogisticsService;

public class ScheduleDeliveryCommand implements Command {

    private final ILogisticsService logisticsService;
    private final Long deliveryId;
    private final Long staffId;

    public ScheduleDeliveryCommand(ILogisticsService logisticsService, Long deliveryId, Long staffId) {
        this.logisticsService = logisticsService; 
        this.deliveryId = deliveryId; 
        this.staffId = staffId;
    }

    @Override
    public void execute() {
        Delivery d = logisticsService.scheduleDelivery(deliveryId, staffId);
        System.out.println("[CMD] Scheduled delivery: " + (d != null ? d.getDeliveryId() : "NOT_FOUND"));
    }
}