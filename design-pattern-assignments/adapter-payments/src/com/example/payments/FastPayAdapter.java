package com.example.payments;
import java.util.Objects;

public class FastPayAdapter implements PaymentGateway {
    private final FastPayClient client;

    public FastPayAdapter(FastPayClient client) {
        this.client = client;
    }

    @Override
    public String charge(String customerId, int amountCents) {
        if(Objects.requireNonNull(customerId).isBlank() || amountCents <= 0) {
            throw new IllegalArgumentException("Invalid payment details");
        }
        return client.payNow(customerId, amountCents);
    } 
}
