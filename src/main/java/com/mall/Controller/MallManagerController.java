package com.mall.controller;
 
import com.mall.model.Agreement;

import com.mall.model.Shop;

import com.mall.service.interfaces.IMallManagerService;

import com.mall.service.interfaces.IAgreementService;

import com.mall.service.interfaces.IShopService;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController

@RequestMapping("/mall-manager")

public class MallManagerController implements IAgreementService.AgreementObserver {
 
    @Autowired

    private IMallManagerService mallManagerService;
 
    @Autowired

    private IAgreementService agreementService;

    @Autowired

    private IShopService shopService;
 
    // Register observer

    @PostConstruct

    public void init() {

        agreementService.registerObserver(this);

    }
 
    // Observer callback

    @Override

    public void updateAgreementStatus(Long agreementId, String status) {

        System.out.println("Mall Manager notified: Agreement " + agreementId + " changed to " + status);

    }
 
    @PostMapping("/shops")

    public Shop createShop(@RequestParam double area,

                           @RequestParam double rent,

                           @RequestParam String tenantInfo) {

        return shopService.createShop(area, rent, tenantInfo);

    }

    @GetMapping("/shops")

    public List<Shop> getAllShops() {

        return mallManagerService.getAllShops();

    }
 
    @GetMapping("/shops/{shopId}")

    public Shop getShopById(@PathVariable long shopId) {

        return shopService.getShopById(shopId);

    }

    @GetMapping("/agreements")

    public List<Agreement> getAllAgreements() {

        return mallManagerService.getAllAgreements();

    }
 
    @GetMapping("/agreements/{agreementId}")

    public Agreement getAgreementById(@PathVariable long agreementId) {

        return mallManagerService.getAgreementById(agreementId);

    }
 


    @GetMapping("/manage-invoices")

    public String manageInvoices() {

        return "Invoices managed successfully.";

    }

    @GetMapping("/shops/{shopId}/monthly-invoice")
    public double generateMonthlyInvoice(@PathVariable long shopId,
                                         @RequestParam double maintenanceFee,
                                         @RequestParam double tax,
                                         @RequestParam double lateFee) {
        return mallManagerService.generateMonthlyInvoice(shopId, maintenanceFee, tax, lateFee);
    }
 
    @GetMapping("/supervise")

    public String supervise() {

        return "Supervision done successfully.";

    }
 
    @GetMapping("/send-notifications")

    public String sendNotifications() {

        return "Notifications sent to shop managers.";

    }

}

 