package com.gpmrks.paymentservice.controller;

import com.gpmrks.paymentservice.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPaymentController {

    @PostMapping
    ResponseEntity<Payment> sendPayment(@RequestBody Payment payment);

}
