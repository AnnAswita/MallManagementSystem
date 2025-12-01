package com.mall.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mall.model.ShopManager;

@Repository
public class ShopManagerInMemoryRepository implements IShopManagerRepository {

    private final Map<Long, ShopManager> storage = new HashMap<>();
    private long nextId = 1L;

    @Override
    public ShopManager save(ShopManager shopManager) {
        if (shopManager.getId() == null) {   // ShopManager needs getId/setId
            shopManager.setId(nextId++);
        }
        storage.put(shopManager.getId(), shopManager);
        return shopManager;
    }

    @Override
    public Optional<ShopManager> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<ShopManager> findAll() {
        return new ArrayList<>(storage.values());
    }
}
