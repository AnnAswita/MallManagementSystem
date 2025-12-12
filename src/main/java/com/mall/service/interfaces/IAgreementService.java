/**
 * Author: Neha
 */
package com.mall.service.interfaces;

import com.mall.model.Agreement;
import com.mall.model.AgreementStatus;

import java.util.List;

public interface IAgreementService {

    Agreement createAgreement(double rentAmount, String duration, double deposit, String conditions, long shopId);

    Agreement updateAgreement(long agreementId, double rentAmount, String duration, double deposit, String conditions);
    
    Agreement updateAgreementStatus(long agreementId, AgreementStatus status);

    Agreement getAgreementById(long agreementId);

    List<Agreement> getAllAgreements();


    // Observer interface
    interface AgreementObserver {
        void updateAgreementStatus(Long agreementId, String status);
    }

    void registerObserver(AgreementObserver observer);
}
