package com.mall.service.interfaces;

import com.mall.model.Agreement;
import com.mall.model.Shop;

import java.util.List;

public interface IMallManagerService {


    String manageInvoices();

    String supervise();

    String sendNotifications();

    double generateMonthlyInvoice(long shopId, double maintenanceFee, double tax, double lateFee);

    List<Shop> getAllShops();

    List<Agreement> getAllAgreements();

    Agreement getAgreementById(long agreementId);
}
