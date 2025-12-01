package com.mall.service.implementations;

import com.mall.model.Shop;
import com.mall.repository.IShopRepository;
import com.mall.service.interfaces.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements IShopService {

    @Autowired
    private IShopRepository shopRepo;

    @Override
    public Shop createShop(double area, double rent, String tenantInfo) {
        List<Shop> shops = shopRepo.loadShops();
        long newId = shops.size() + 1;

        Shop shop = new Shop();
        shop.setShopID(newId);
        shop.setArea(area);
        shop.setRent(rent);
        shop.setTenantInfo(tenantInfo);

        shops.add(shop);
        shopRepo.saveShops(shops);

        return shop;
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepo.loadShops();
    }
}
