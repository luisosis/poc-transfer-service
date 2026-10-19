package com.poc.transfer.infrastructure.adapter.out.rest;


import com.poc.transfer.infrastructure.adapter.out.rest.dto.BeneficiaryInquiryRequest;
import com.poc.transfer.infrastructure.adapter.out.rest.dto.BeneficiaryProviderResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "transfer-provider")
@Path("/api/beneficiaries")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface BeneficiaryProviderClient {

    @POST
    @Path("/inquiry")
    BeneficiaryProviderResponse findBeneficiary(
            BeneficiaryInquiryRequest request
    );
}
