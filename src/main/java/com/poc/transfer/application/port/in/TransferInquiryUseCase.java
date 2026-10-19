package com.poc.transfer.application.port.in;

import com.poc.transfer.domain.model.TransferInquiry;

import java.math.BigDecimal;

public interface TransferInquiryUseCase {

    TransferInquiry inquiry(
            String numberAccount
    );
}
