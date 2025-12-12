package com.mall.service.implementations;

import com.mall.service.interfaces.IInvoice;

// Decorator Pattern - Concrete Decorator (Tax)
public class TaxDecorator extends InvoiceDecorator {

    private final double taxRate; // .18 for 18%

    public TaxDecorator(IInvoice wrappedInvoice, double taxRate) {
        super(wrappedInvoice);
        this.taxRate = taxRate;
    }

    @Override
    public double generateAmount() {
        double subtotal = wrappedInvoice.generateAmount();
        return subtotal + (subtotal * taxRate);
    }

    @Override
    public String getDescription() {
        return wrappedInvoice.getDescription()
                + " + Tax: " + (taxRate * 100) + "%";
    }
}
