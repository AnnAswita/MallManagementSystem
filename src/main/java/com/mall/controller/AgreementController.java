package com.mall.controller;
import com.mall.entity.Agreement;
import com.mall.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agreements")
public class AgreementController {

    @Autowired
    private AgreementService agreementService;

    @PostMapping
    public ResponseEntity<Agreement> createAgreement(@RequestBody Agreement agreement) {
        return ResponseEntity.ok(agreementService.createAgreement(agreement));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agreement> getAgreementById(@PathVariable Long id) {
        return ResponseEntity.ok(agreementService.getAgreementById(id));
    }

    @GetMapping
    public ResponseEntity<List<Agreement>> getAllAgreements() {
        return ResponseEntity.ok(agreementService.getAllAgreements());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agreement> updateAgreement(@PathVariable Long id, @RequestBody Agreement updatedAgreement) {
        return ResponseEntity.ok(agreementService.updateAgreement(id, updatedAgreement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgreement(@PathVariable Long id) {
        agreementService.deleteAgreement(id);
        return ResponseEntity.ok("Agreement deleted successfully");
    }
}