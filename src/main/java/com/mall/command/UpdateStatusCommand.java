//Author Ann Aswita 
package com.mall.command;

import com.mall.service.interfaces.IDeliveryService;

public class UpdateStatusCommand implements Command {
	
    private final IDeliveryService deliveryService;
    private final Long deliveryID;
    private final Long staffId;
    //private final String newStatus;
    public UpdateStatusCommand(IDeliveryService deliveryService, Long deliveryID, Long staffId) {
        this.deliveryService = deliveryService; 
        this.deliveryID = deliveryID;
        this.staffId = staffId;
        //this.newStatus = newStatus;
    }

	@Override
    public void execute() {
        deliveryService.updateStatus(deliveryID,staffId);
        System.out.println("[CMD] Updated status " + deliveryID );
    }
}