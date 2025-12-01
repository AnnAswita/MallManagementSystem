package com.mall.service;

import com.mall.entity.Agreement;
import com.mall.repository.AgreementJsonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgreementService {

    private final AgreementJsonRepository repository = new AgreementJsonRepository();

    public Agreement createAgreement(Agreement agreement) {
        return repository.save(agreement);
    }

    public Agreement getAgreementById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Agreement> getAllAgreements() {
        return repository.findAll();
    }

    public Agreement updateAgreement(Long id, Agreement updatedAgreement) {
        Agreement existing = getAgreementById(id);
        if (existing == null) return null;

        updatedAgreement.setId(id);
        return repository.save(updatedAgreement);
    }

    public void deleteAgreement(Long id) {
        repository.delete(id);
    }
}
