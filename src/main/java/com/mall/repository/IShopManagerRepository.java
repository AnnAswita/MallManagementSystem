package com.mall.repository;

import java.util.List;
import java.util.Optional;

import com.mall.model.ShopManager;

public interface IShopManagerRepository {

    ShopManager save(ShopManager shopManager);

    Optional<ShopManager> findById(Long id);

    List<ShopManager> findAll();
}
