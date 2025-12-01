package com.mall.service.interfaces;

import com.mall.model.Shop;
import java.util.List;

public interface IShopService {
    Shop createShop(double area, double rent, String tenantInfo);
    List<Shop> getAllShops();
}
