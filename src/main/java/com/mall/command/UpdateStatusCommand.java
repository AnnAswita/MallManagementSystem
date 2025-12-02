package com.mall.command;

import com.mall.service.interfaces.IDeliveryService;

public class UpdateStatusCommand implements Command {
	
    private final IDeliveryService deliveryService;
    private final Long deliveryID;
    //private final String newStatus;
    public UpdateStatusCommand(IDeliveryService deliveryService, Long deliveryID) {
        this.deliveryService = deliveryService; 
        this.deliveryID = deliveryID; 
        //this.newStatus = newStatus;
    }

	@Override
    public void execute() {
        deliveryService.updateStatus(deliveryID);
        //System.out.println("[CMD] Updated status " + deliveryID + " -> " + newStatus);
    }
}