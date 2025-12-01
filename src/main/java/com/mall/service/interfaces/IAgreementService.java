package com.mall.service.interfaces;

import com.mall.model.Agreement;
import java.util.List;

public interface IAgreementService {

    Agreement createAgreement(double rentAmount, String duration, double deposit, String conditions, long shopId);

    List<Agreement> getAllAgreements();

    // Observer interface
    interface AgreementObserver {
        void updateAgreementStatus(Long agreementId, String status);
    }

    void registerObserver(AgreementObserver observer);
}
