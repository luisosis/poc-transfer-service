package com.poc.transfer.domain.model;

public record Beneficiary(
        String beneficiaryId,
        String fullName,
        String documentType,
        String maskedDocumentNumber,
        String maskedAccountNumber,
        String bankName,
        boolean active,
        boolean eligibleToReceive
) {
}
