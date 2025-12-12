package com.mall.service.implementations;

import com.mall.service.interfaces.IInvoice;

// Decorator Pattern - Concrete Decorator (Maintenance fee)
public class MaintenanceDecorator extends InvoiceDecorator {

    private final double maintenanceFee;

    public MaintenanceDecorator(IInvoice wrappedInvoice, double maintenanceFee) {
        super(wrappedInvoice);
        this.maintenanceFee = maintenanceFee;
    }

    @Override
    public double generateAmount() {
        return wrappedInvoice.generateAmount() + maintenanceFee;
    }

    @Override
    public String getDescription() {
        return wrappedInvoice.getDescription()
                + " + Maintenance: " + maintenanceFee;
    }
}
