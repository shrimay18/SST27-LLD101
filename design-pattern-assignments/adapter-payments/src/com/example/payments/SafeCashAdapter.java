package com.example.payments;

import java.util.Objects;

public class SafeCashAdapter implements PaymentGateway {
    private final SafeCashClient client;

    public SafeCashAdapter(SafeCashClient client) {
        this.client = client;
    }

    public String charge(String customerId, int amountCents) {
        if(Objects.requireNonNull(customerId).isBlank() || amountCents <= 0) {
            throw new IllegalArgumentException("Invalid payment details");
        }
        SafeCashPayment payment = client.createPayment(amountCents, customerId);
        return payment.confirm();
    }
}
