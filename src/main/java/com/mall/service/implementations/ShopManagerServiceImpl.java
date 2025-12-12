package com.mall.service.implementations;

import com.mall.model.Agreement;
import com.mall.service.interfaces.IAgreementService;
import com.mall.service.interfaces.IShopManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopManagerServiceImpl implements IShopManagerService {

    @Autowired
    private IAgreementService agreementService;


    @Override
    public List<Agreement> getAgreementsForShop(long shopId) {
        return agreementService.getAllAgreements()
                .stream()
                .filter(a -> a.getShopId() == shopId)
                .collect(Collectors.toList());
    }

    @Override
    public String manageRent() {
        return "Rent managed successfully.";
    }

    @Override
    public String requestDelivery() {
        return "Delivery requested successfully.";
    }
}
