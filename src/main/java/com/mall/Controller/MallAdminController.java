package com.mall.Controller;

import com.mall.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mall-admin")
public class MallAdminController {

    private final AgreementService agreementService;

    @Autowired
    public MallAdminController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @PutMapping("/agreements/{id}/approve")
    public String approveAgreement(@PathVariable("id") Long agreementId) {
        return agreementService.approveAgreement(agreementId);
    }

    @GetMapping("/agreements")
    public String viewAllAgreements() {
        return agreementService.listAllAgreements();
    }
}
