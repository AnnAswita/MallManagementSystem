package com.mall.Controller;

import com.mall.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mall-manager")
public class MallManagerController {

    private final AgreementService agreementService;

    @Autowired
    public MallManagerController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @PostMapping("/agreements")
    public String createAgreement(@RequestParam Long shopId,
                                  @RequestParam Long tenantId) {
        return agreementService.createAgreement(shopId, tenantId);
    }

    @PutMapping("/agreements/{id}/approve")
    public String approveAgreement(@PathVariable("id") Long agreementId) {
        return agreementService.approveAgreement(agreementId);
    }

    @PutMapping("/agreements/{id}/terminate")
    public String terminateAgreement(@PathVariable("id") Long agreementId) {
        return agreementService.terminateAgreement(agreementId);
    }

    @GetMapping("/agreements")
    public String listAllAgreements() {
        return agreementService.listAllAgreements();
    }
}
