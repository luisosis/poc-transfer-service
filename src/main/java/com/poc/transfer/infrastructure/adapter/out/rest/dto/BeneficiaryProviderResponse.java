package com.poc.transfer.infrastructure.adapter.out.rest.dto;

public record BeneficiaryProviderResponse(
        String beneficiaryId,
        String fullName,
        String documentType,
        String documentNumber,
        String accountNumber,
        String bankName,
        String currency,
        boolean active) {
}
