package com.mall.service.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mall.model.Delivery;
import com.mall.decorator.DeliveryFee;
import com.mall.decorator.BaseDeliveryFee;
import com.mall.decorator.ExpressDeliveryFee;
import com.mall.decorator.WeightFeeDecorator;
import com.mall.decorator.SizeFeeDecorator;
import com.mall.service.interfaces.IDeliveryService;
import com.mall.service.interfaces.ILogisticsService;

@Service
public class LogisticsServiceImpl implements ILogisticsService {

    private final IDeliveryService deliveryService;
    //private final INotificationService notificationService;

    public LogisticsServiceImpl(IDeliveryService deliveryService) {
        this.deliveryService = deliveryService;
        //this.notificationService = notificationService;
    }

    @Override
    public List<Delivery> getPendingDeliveries() {
        return deliveryService.getPendingDeliveries();
    }

    @Override
    public Delivery scheduleDelivery(Long deliveryId, Long staffId) {
        Delivery d = deliveryService.getDelivery(deliveryId);
        if (d == null) return null;

        // Fee calculation (Decorator)
        DeliveryFee fee = new BaseDeliveryFee();
        if ("EXPRESS".equalsIgnoreCase(d.getType())) {
        	fee = new ExpressDeliveryFee(fee);
        }
        fee = new WeightFeeDecorator(fee, d.getWeight());
        fee = new SizeFeeDecorator(fee, d.getSizeCategory());
        System.out.println("[FEE] Delivery " + deliveryId+ " fee = " + fee.calculateFee());

        // Assign & change state via DeliveryService
        deliveryService.assignDelivery(deliveryId, staffId);

        // Notify staff via observer pattern
        //notificationService.notifyObserver(staffId, "You have been assigned to delivery " + deliveryID);

        return deliveryService.getDelivery(deliveryId);
    }

    @Override
    public void updateDeliveryStatus(Long deliveryId, String status) {
        deliveryService.updateStatus(deliveryId);
        Delivery d = deliveryService.getDelivery(deliveryId);
//        if (d != null && d.getAssignedStaffId() != null) {
//            notificationService.notifyObserver(d.getAssignedStaffID(), "Delivery " + deliveryID + " status -> " + status);
//        }
    }
}