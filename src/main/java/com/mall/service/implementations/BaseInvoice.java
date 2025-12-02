package com.mall.service.implementations;

import com.mall.service.interfaces.IInvoice;

// Decorator Pattern - Concrete Component
public class BaseInvoice implements IInvoice {

    private final double baseAmount;

    public BaseInvoice(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    @Override
    public double generateAmount() {
        return baseAmount;
    }

    @Override
    public String getDescription() {
        return "Base rent: " + baseAmount;
    }
}
