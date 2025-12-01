package com.mall.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AgreementService {

    // Very simple in-memory storage: agreementId -> status
    private final Map<Long, String> agreements = new HashMap<>();
    private long nextId = 1L;

    // Create a new agreement for a shop + tenant
    public String createAgreement(Long shopId, Long tenantId) {
        long id = nextId++;
        agreements.put(id, "PENDING");

        return "Created agreement " + id +
                " for shop " + shopId +
                " and tenant " + tenantId +
                " with status PENDING";
    }

    // Approve: PENDING -> ACTIVE
    public String approveAgreement(Long agreementId) {
        agreements.put(agreementId, "ACTIVE");
        return "Agreement " + agreementId + " approved (status ACTIVE)";
    }

    // Terminate: ACTIVE -> TERMINATED
    public String terminateAgreement(Long agreementId) {
        agreements.put(agreementId, "TERMINATED");
        return "Agreement " + agreementId + " terminated (status TERMINATED)";
    }

    // View all agreements (for admin/manager dashboards)
    public String listAllAgreements() {
        if (agreements.isEmpty()) {
            return "No agreements found.";
        }
        return "Agreements: " + agreements.toString();
    }

    // View agreements for a tenant (shop manager)
    public String listAgreementsForTenant(Long tenantId) {
        // TODO: Later filter by tenantId using real Agreement objects
        return "Agreements for tenant " + tenantId + ": " + agreements.toString();
    }
}
