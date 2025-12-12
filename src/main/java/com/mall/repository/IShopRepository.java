package com.mall.repository;

import com.mall.model.Shop;
import java.util.List;

public interface IShopRepository {
    List<Shop> loadShops();
    void saveShops(List<Shop> shops);
}
