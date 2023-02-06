package com.gpmrks.paymentservice.model;

import java.io.Serializable;

public class Payment implements Serializable {

    private Long id;
    private Long userId;
    private Long productId;
    private String cardNumber;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
