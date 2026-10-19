package com.poc.transfer.infrastructure.adapter.out.rest;

import com.poc.transfer.application.port.out.BeneficiaryProviderPort;
import com.poc.transfer.domain.model.Beneficiary;
import com.poc.transfer.infrastructure.adapter.out.rest.dto.BeneficiaryInquiryRequest;
import com.poc.transfer.infrastructure.adapter.out.rest.dto.BeneficiaryProviderResponse;
import com.poc.transfer.infrastructure.adapter.out.rest.mapper.BeneficiaryProviderMapper;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class BeneficiaryProviderAdapter implements BeneficiaryProviderPort {
    private final BeneficiaryProviderClient beneficiaryProviderClient;
    private final BeneficiaryProviderMapper beneficiaryProviderMapper;

    public BeneficiaryProviderAdapter(
            @RestClient BeneficiaryProviderClient beneficiaryProviderClient,
            BeneficiaryProviderMapper beneficiaryProviderMapper) {
        this.beneficiaryProviderClient = beneficiaryProviderClient;
        this.beneficiaryProviderMapper = beneficiaryProviderMapper;
    }

    @Override
    public Beneficiary findBeneficiary(String beneficiaryId) {
        BeneficiaryProviderResponse response =
                beneficiaryProviderClient.findBeneficiary(new BeneficiaryInquiryRequest("001234567890"));

        return beneficiaryProviderMapper.toDomain(response);
    }
}
