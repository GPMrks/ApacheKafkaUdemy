package com.gpmrks.paymentservice.service.impl;

import com.gpmrks.paymentservice.model.Payment;
import com.gpmrks.paymentservice.service.IPaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentService implements IPaymentService {

    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT SERVICE ::: Payment received {}", payment);
    }
}
