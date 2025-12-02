package com.mall.service.implementations;

import com.mall.model.Agreement;
import com.mall.model.Shop;
import com.mall.service.interfaces.IAgreementService;
import com.mall.service.interfaces.IShopService;
import com.mall.service.interfaces.IMallManagerService;
import com.mall.service.interfaces.IInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallManagerServiceImpl implements IMallManagerService {

    @Autowired
    private IShopService shopService;

    @Autowired
    private IAgreementService agreementService;

    // -------------------------
    // Manager-specific actions
    // -------------------------
    @Override
    public String manageInvoices() {
        return "Invoices managed successfully.";
    }

    @Override
    public String supervise() {
        return "Supervision done successfully.";
    }

    @Override
    public String sendNotifications() {
        return "Notifications sent to shop managers.";
    }

    // -------------------------
    // Monthly invoice generation using Decorator pattern
    // -------------------------
    @Override
    public double generateMonthlyInvoice(long shopId, double maintenanceFee, double tax, double lateFee) {

        List<Agreement> shopAgreements = agreementService.getAllAgreements()
                .stream()
                .filter(a -> a.getShopId() == shopId)
                .toList();

        double baseAmount = shopAgreements.stream()
                .mapToDouble(Agreement::getRentAmount)
                .sum();

        // Apply decorators
        IInvoice invoice = new BaseInvoice(baseAmount);
        invoice = new MaintenanceDecorator(invoice, maintenanceFee);
        invoice = new TaxDecorator(invoice, tax);
        invoice = new LateFeeDecorator(invoice, lateFee);

        return invoice.generateAmount();
    }


    @Override
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    @Override
    public List<Agreement> getAllAgreements() {
        return agreementService.getAllAgreements();
    }

    @Override
    public Agreement getAgreementById(long agreementId) {
        return agreementService.getAgreementById(agreementId);
    }
}
