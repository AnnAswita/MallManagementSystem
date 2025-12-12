package com.mall.service.implementations;

import com.mall.service.interfaces.IInvoice;

// Decorator Pattern - Abstract Decorator
public abstract class InvoiceDecorator implements IInvoice {

    protected final IInvoice wrappedInvoice;

    protected InvoiceDecorator(IInvoice wrappedInvoice) {
        this.wrappedInvoice = wrappedInvoice;
    }

    @Override
    public double generateAmount() {
        // Default: just call wrapped invoice
        return wrappedInvoice.generateAmount();
    }

    @Override
    public String getDescription() {
        // Default: just call wrapped invoice
        return wrappedInvoice.getDescription();
    }
}
