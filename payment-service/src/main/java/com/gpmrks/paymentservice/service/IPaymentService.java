package com.gpmrks.paymentservice.service;

import com.gpmrks.paymentservice.model.Payment;

public interface IPaymentService {

    void sendPayment(Payment payment);

}
