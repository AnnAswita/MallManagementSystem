package com.mall.service;

import com.mall.entity.Shop;
import com.mall.repository.ShopJsonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final ShopJsonRepository repository = new ShopJsonRepository();

    public Shop createShop(Shop shop) {
        return repository.save(shop);
    }

    public Shop getShopById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Shop> getAllShops() {
        return repository.findAll();
    }

    public Shop updateShop(Long id, Shop updatedShop) {
        Shop existing = getShopById(id);
        if (existing == null) return null;

        updatedShop.setShopID(id);
        return repository.save(updatedShop);
    }

    public void deleteShop(Long id) {
        repository.delete(id);
    }
}
