package com.mall.Controller;

import com.mall.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop-manager")
public class ShopManagerController {

    private final AgreementService agreementService;

    @Autowired
    public ShopManagerController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @GetMapping("/agreements/{tenantId}")
    public String viewMyAgreements(@PathVariable("tenantId") Long tenantId) {
        return agreementService.listAgreementsForTenant(tenantId);
    }
}
