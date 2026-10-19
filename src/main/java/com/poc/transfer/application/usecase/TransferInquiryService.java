package com.poc.transfer.application.usecase;

import com.poc.transfer.application.port.in.TransferInquiryUseCase;
import com.poc.transfer.application.port.out.BeneficiaryProviderPort;
import com.poc.transfer.domain.model.Beneficiary;
import com.poc.transfer.domain.model.TransferInquiry;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransferInquiryService implements TransferInquiryUseCase {

    private final BeneficiaryProviderPort beneficiaryProviderPort;

    public TransferInquiryService(BeneficiaryProviderPort beneficiaryProviderPort) {
        this.beneficiaryProviderPort = beneficiaryProviderPort;
    }

    @Override
    public TransferInquiry inquiry(String numberAccount) {

        validateInquiry(numberAccount);
        Beneficiary beneficiary =
                beneficiaryProviderPort.findBeneficiary(numberAccount);

        return new TransferInquiry(
                beneficiary
        );
    }


    private void validateInquiry(
            String beneficiaryId) {

        if (beneficiaryId == null || beneficiaryId.isBlank()) {
            throw new IllegalArgumentException(
                    "El identificador del beneficiario es obligatorio");
        }

    }


}
