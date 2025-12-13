/**
 * Author: Neha , Sumayya
 */
package com.mall.controller;
 
import com.mall.model.Agreement;
import com.mall.model.AgreementStatus;
import com.mall.model.Shop;

import com.mall.service.interfaces.IShopManagerService;
import com.mall.service.interfaces.IShopService;

import com.mall.service.interfaces.IAgreementService;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

 
import java.util.List;
 
@RestController

@RequestMapping("/shop-manager")

public class ShopManagerController implements IAgreementService.AgreementObserver {
 
    @Autowired

    private IShopService shopService;
 
    @Autowired

    private IAgreementService agreementService;

    @Autowired

    private IShopManagerService shopManagerService;

 
    // Register as observer

    @PostConstruct

    public void init() {

        agreementService.registerObserver(this);

    }
 
    // Observer callback

    @Override

    public void updateAgreementStatus(Long agreementId, AgreementStatus status) {

        System.out.println("Shop Manager notified: Agreement " + agreementId + " status changed to " + status);

    }

    
 
    @PutMapping("/shops/{shopId}")

    public Shop updateShop(@PathVariable long shopId,

    		@RequestBody Shop shopRequest){

        return shopService.updateShop(shopId,shopRequest.getArea(),shopRequest.getRent(),shopRequest.getTenantInfo());

    }
 
    @GetMapping("/shops/{shopId}")

    public Shop getShopById(@PathVariable long shopId) {

        return shopService.getShopById(shopId);

    }
 
 


    @PutMapping("/agreements/{agreementId}")

    public Agreement updateAgreement(@PathVariable long agreementId,

                                     @RequestParam double rentAmount,

                                     @RequestParam String duration,

                                     @RequestParam double deposit,

                                     @RequestParam String conditions) {

        return agreementService.updateAgreement(agreementId, rentAmount, duration, deposit, conditions);

    }
 
    // Get all agreements for a specific shop

    @GetMapping("/shops/{shopId}/agreements")

    public List<Agreement> getAgreementsForShop(@PathVariable long shopId) {

       

        return shopManagerService.getAgreementsForShop(shopId);

    }
 

    @GetMapping("/manage-rent")

    public String manageRent() {

        return "Rent managed successfully.";

    }
 
    @PostMapping("/request-delivery")

    public String requestDelivery() {

        return "Delivery requested successfully.";

    }

}

 