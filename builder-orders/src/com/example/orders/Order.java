package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent; // 0..100 expected, but not enforced
    private final boolean expedited;
    private final String notes;

    private Order(Builder build) {
        this.id = build.id;
        this.customerEmail = build.customerEmail;
        List<OrderLine> copy = new ArrayList<>();
        for (OrderLine l : build.lines) {
            copy.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
        }
        this.lines = copy;
        this.discountPercent = build.discountPercent;
        this.expedited = build.expedited;
        this.notes = build.notes;
    }

    public static class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines;
        private Integer discountPercent; // 0..100 expected, but not enforced
        private boolean expedited;
        private String notes;

        public Builder(String id, String email, List<OrderLine> lines) {
            if (id == null || email == null || lines == null || lines.isEmpty()) {
                throw new IllegalArgumentException("id, email, and at least one line are required");
            }
            this.id = id;
            this.customerEmail = email;
            this.lines = new ArrayList<>(lines); // defensive copy
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email format");
            }
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Discount must be between 0 and 100");
            }
            if (lines == null || lines.isEmpty()) {
                throw new IllegalArgumentException("Order must have at least one line");
            }
            return new Order(this);
        }
    }    

    public List<OrderLine> getLines() {
        List<OrderLine> copy = new ArrayList<>();
        for (OrderLine l : lines) {
            copy.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
        }
        return Collections.unmodifiableList(lines);
    }
    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }
}
