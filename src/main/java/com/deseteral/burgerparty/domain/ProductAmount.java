package com.deseteral.burgerparty.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductAmount {
    private final String product;
    private final Double amount;

    @JsonCreator
    ProductAmount(
        @JsonProperty("product") String product,
        @JsonProperty("amount") Double amount
    ) {
        this.product = product;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public Double getAmount() {
        return amount;
    }

    public static Builder builder(ProductAmount productAmount) {
        return new Builder(productAmount);
    }

    public static final class Builder {
        private String product;
        private Double amount;

        private Builder(ProductAmount productAmount) {
            this.product = productAmount.getProduct();
            this.amount = productAmount.getAmount();
        }

        public ProductAmount build() {
            return new ProductAmount(product, amount);
        }
    }
}
