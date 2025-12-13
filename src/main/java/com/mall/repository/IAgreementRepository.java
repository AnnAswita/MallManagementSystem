/**
 * Author: Neha
 */
package com.mall.repository;

import com.mall.model.Agreement;
import java.util.List;

public interface IAgreementRepository {
    List<Agreement> loadAgreements();
    void saveAgreements(List<Agreement> agreements);
}
