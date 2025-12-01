package com.mall.service.implementations;

import com.mall.model.Agreement;
import com.mall.repository.IAgreementRepository;
import com.mall.service.interfaces.IAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        // Notify all observers
        notifyObservers(newId, "SIGNED");

        return ag;
    }

    @Override
    public List<Agreement> getAllAgreements() {
        return agreeRepo.loadAgreements();
    }
}
