package com.mall.controller;

import com.mall.model.Agreement;
import com.mall.service.interfaces.IAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agreements")
public class AgreementController {

    @Autowired
    private IAgreementService agreementService;

    // Register a simple observer (example)
    public AgreementController() {
        // This could be replaced with a real MallManager observer class
        agreementService.registerObserver((agreementId, status) ->
                System.out.println("Observer: Agreement " + agreementId + " status: " + status)
        );
    }

    // Create a new agreement
    @PostMapping("/create")
    public Agreement createAgreement(@RequestParam double rentAmount,
                                     @RequestParam String duration,
                                     @RequestParam double deposit,
                                     @RequestParam String conditions,
                                     @RequestParam long shopId) {
        return agreementService.createAgreement(rentAmount, duration, deposit, conditions, shopId);
    }

    // Get all agreements
    @GetMapping("/all")
    public List<Agreement> getAllAgreements() {
        return agreementService.getAllAgreements();
    }
}
