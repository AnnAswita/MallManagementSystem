package com.mall.controller;

import com.mall.model.Shop;
import com.mall.service.interfaces.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private IShopService shopService;

    // Create a new shop
    @PostMapping("/create")
    public Shop createShop(@RequestParam double area,
                           @RequestParam double rent,
                           @RequestParam String tenantInfo) {
        return shopService.createShop(area, rent, tenantInfo);
    }

    // Get all shops
    @GetMapping("/all")
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }
    //get shop by id
    @GetMapping("/{id}")
    public Shop getShopById(@PathVariable long id) {
        return shopService.getShopById(id);
    }
    //update shop by id
    @PutMapping("/{id}")
    public Shop updateShop(@PathVariable long id,
                       @RequestBody Shop shopRequest) {
        return shopService.updateShop(
        id,
        shopRequest.getArea(),
        shopRequest.getRent(),
        shopRequest.getTenantInfo()
        );
    }

}

