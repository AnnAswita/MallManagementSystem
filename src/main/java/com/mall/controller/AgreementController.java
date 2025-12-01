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

    // Create Agreement
    @PostMapping("/create")
    public Agreement createAgreement(@RequestParam double rentAmount,
                                     @RequestParam String duration,
                                     @RequestParam double deposit,
                                     @RequestParam String conditions,
                                     @RequestParam long shopId) {
        return agreementService.createAgreement(
                rentAmount, duration, deposit, conditions, shopId
        );
    }

    // Update Agreement
    @PutMapping("/update/{id}")
    public Agreement updateAgreement(@PathVariable long id,
                                     @RequestParam double rentAmount,
                                     @RequestParam String duration,
                                     @RequestParam double deposit,
                                     @RequestParam String conditions) {
        return agreementService.updateAgreement(id, rentAmount, duration, deposit, conditions);
    }

    // Fetch one
    @GetMapping("/{id}")
    public Agreement getAgreement(@PathVariable long id) {
        return agreementService.getAgreementById(id);
    }

    // Fetch all
    @GetMapping("/all")
    public List<Agreement> getAllAgreements() {
        return agreementService.getAllAgreements();
    }
}
