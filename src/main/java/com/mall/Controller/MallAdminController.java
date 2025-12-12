package com.mall.controller;
 
import com.mall.model.Shop;

import com.mall.service.interfaces.IShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/mall-admin")

public class MallAdminController {
 
    @Autowired

    private IShopService shopService;
 

    @PostMapping("/add-layout")

    public String addMallLayout() {

        return "Mall layout added.";

    }
 
    @PostMapping("/create-shop")

    public Shop createShop(@RequestParam double area,

                           @RequestParam double rent,

                           @RequestParam String tenantInfo) {

        return shopService.createShop(area, rent, tenantInfo);

    }
 
    @PostMapping("/approve-agreement")

    public String approveAgreement(@RequestParam long agreementId) {

        return "Agreement " + agreementId + " approved.";

    }

}

 