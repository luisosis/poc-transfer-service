package com.poc.transfer.infrastructure.adapter.in.rest;

import com.poc.transfer.application.port.in.TransferInquiryUseCase;
import com.poc.transfer.domain.model.TransferInquiry;
import com.poc.transfer.infrastructure.adapter.in.rest.dto.TransferInquiryRequest;
import com.poc.transfer.infrastructure.adapter.in.rest.dto.TransferInquiryResponse;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/transfers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransferInquiryResource {

    private final TransferInquiryUseCase transferInquiryUseCase;

    public TransferInquiryResource(TransferInquiryUseCase transferInquiryUseCase) {
        this.transferInquiryUseCase = transferInquiryUseCase;
    }

    @POST
    @Path("/inquiry")
    public Response inquiry(@Valid TransferInquiryRequest request) {

        TransferInquiry result = transferInquiryUseCase.inquiry(
                request.numberAccount()
        );
        var response = new TransferInquiryResponse(
                new TransferInquiryResponse.BeneficiaryData(
                        result.beneficiary().beneficiaryId(),
                        result.beneficiary().fullName(),
                        result.beneficiary().documentType(),
                        result.beneficiary().maskedDocumentNumber(),
                        result.beneficiary().maskedAccountNumber(),
                        result.beneficiary().bankName(),
                        result.beneficiary().active(),
                        result.beneficiary().eligibleToReceive()
                )
        );

        return Response.ok(response).build();
    }
}
