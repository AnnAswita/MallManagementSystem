package com.mall.service.interfaces;

import com.mall.model.Agreement;
import com.mall.model.Shop;

import java.util.List;

public interface IShopManagerService {


    List<Agreement> getAgreementsForShop(long shopId);

    String manageRent();

    String requestDelivery();
}
