package com.mall.service.implementations;

import com.mall.model.Agreement;
import com.mall.repository.IAgreementRepository;
import com.mall.service.interfaces.IAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgreementServiceImpl implements IAgreementService {

    @Autowired
    private IAgreementRepository agreeRepo;

    private final List<IAgreementService.AgreementObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(IAgreementService.AgreementObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Long agreementId, String status) {
        observers.forEach(o -> o.updateAgreementStatus(agreementId, status));
    }
    //create agreement
    @Override
    public Agreement createAgreement(double rentAmount, String duration, double deposit, String conditions, long shopId) {
        List<Agreement> agreements = agreeRepo.loadAgreements();
        long newId = agreements.size() + 1;

        Agreement ag = new Agreement();
        ag.setRentAmount(rentAmount);
        ag.setDuration(duration);
        ag.setDeposit(deposit);
        ag.setConditions(conditions);
        ag.setShopId(shopId);

        try {
            var f = Agreement.class.getDeclaredField("id");
            f.setAccessible(true);
            f.set(ag, newId);
        } catch (Exception ignored) {}

        agreements.add(ag);
        agreeRepo.saveAgreements(agreements);

  
        notifyObservers(newId, "SIGNED");

        return ag;
    }

     // Update existing agreement
    @Override
    public Agreement updateAgreement(long agreementId, double rentAmount, String duration, double deposit, String conditions) {
        List<Agreement> agreements = agreeRepo.loadAgreements();
        Optional<Agreement> existing = agreements.stream()
                .filter(a -> a.getId() == agreementId)
                .findFirst();

        if (existing.isPresent()) {
            Agreement ag = existing.get();
            ag.setRentAmount(rentAmount);
            ag.setDuration(duration);
            ag.setDeposit(deposit);
            ag.setConditions(conditions);

            agreeRepo.saveAgreements(agreements);
            notifyObservers(agreementId, "UPDATED"); // Notify observers
            return ag;
        } else {
            return null; // or throw exception
        }
    }

    // Get agreement by ID
    @Override
    public Agreement getAgreementById(long agreementId) {
        return agreeRepo.loadAgreements().stream()
                .filter(a -> a.getId() == agreementId)
                .findFirst()
                .orElse(null);
    }

    // Get all agreements
    @Override
    public List<Agreement> getAllAgreements() {
        return agreeRepo.loadAgreements();
    }
}
