package com.mall.service.interfaces;

import java.util.List;

import com.mall.model.Delivery;

public interface ILogisticsService {
    List<Delivery> getPendingDeliveries();
    Delivery scheduleDelivery(Long deliveryId, Long staffId);
    void updateDeliveryStatus(Long deliveryID, String status, Long staffId);
}