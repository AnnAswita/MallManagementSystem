/**
 * Author: Neha
 */
package com.mall.service.interfaces;

import com.mall.model.Shop;
import java.util.List;

public interface IShopService {
    Shop createShop(double area, double rent, String tenantInfo);
    Shop updateShop(long shopId, double area, double rent, String tenantInfo);

    Shop getShopById(long shopId);
    List<Shop> getAllShops();
}
