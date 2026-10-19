package com.poc.transfer.infrastructure.adapter.out.rest.mapper;

import com.poc.transfer.domain.model.Beneficiary;
import com.poc.transfer.infrastructure.adapter.out.rest.dto.BeneficiaryProviderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "jakarta-cdi")
public interface BeneficiaryProviderMapper {
    @Mapping(
            target = "maskedDocumentNumber",
            expression = "java(mask(response.documentNumber()))"
    )
    @Mapping(
            target = "maskedAccountNumber",
            expression = "java(mask(response.accountNumber()))"
    )
    @Mapping(target = "eligibleToReceive", ignore = true)
    Beneficiary toDomain(BeneficiaryProviderResponse response);

    default String mask(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        int visibleCharacters = Math.min(4, value.length());

        return "*".repeat(value.length() - visibleCharacters)
                + value.substring(value.length() - visibleCharacters);
    }
}
