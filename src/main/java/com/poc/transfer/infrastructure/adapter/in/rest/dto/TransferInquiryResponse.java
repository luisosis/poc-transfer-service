package com.poc.transfer.infrastructure.adapter.in.rest.dto;

import java.math.BigDecimal;

public record TransferInquiryResponse(
        BeneficiaryData beneficiary) {

    public record BeneficiaryData(
            String beneficiaryId,
            String fullName,
            String documentType,
            String documentNumberMasked,
            String accountNumberMasked,
            String bankName,
            boolean active,
            boolean eligibleToReceive
    ) {
    }
}
