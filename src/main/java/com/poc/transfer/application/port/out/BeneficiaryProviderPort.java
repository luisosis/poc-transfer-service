package com.poc.transfer.application.port.out;

import com.poc.transfer.domain.model.Beneficiary;

public interface BeneficiaryProviderPort {
    Beneficiary findBeneficiary(String beneficiaryId);
}
