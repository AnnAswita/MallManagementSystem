package com.mall.service.interfaces;

// Decorator Pattern - Component
public interface IInvoice {

    // Calculate total amount of this invoice
    double generateAmount();

    // Description of what this invoice contains
    String getDescription();
}
