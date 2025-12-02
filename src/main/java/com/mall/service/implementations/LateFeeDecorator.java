package com.mall.service.implementations;

import com.mall.service.interfaces.IInvoice;

// Decorator Pattern - Concrete Decorator (Late fee)
public class LateFeeDecorator extends InvoiceDecorator {

    private final double lateFee;

    public LateFeeDecorator(IInvoice wrappedInvoice, double lateFee) {
        super(wrappedInvoice);
        this.lateFee = lateFee;
    }

    @Override
    public double generateAmount() {
        return wrappedInvoice.generateAmount() + lateFee;
    }

    @Override
    public String getDescription() {
        return wrappedInvoice.getDescription()
                + " + Late fee: " + lateFee;
    }
}
