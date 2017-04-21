package com.deseteral.burgerparty.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Product {
    @Id
    private final String id;
    private final String name;
    private final Integer energy;
    private final Double price;
    private final String unit;
    private final String imageUrl;

    @JsonCreator
    Product(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("energy") Integer energy,
        @JsonProperty("price") Double price,
        @JsonProperty("unit") String unit,
        @JsonProperty("image") String imageUrl
    ) {
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.price = price;
        this.unit = unit;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getEnergy() {
        return energy;
    }

    public Double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static Builder builder(Product product) {
        return new Builder(product);
    }

    public static final class Builder {
        private String id;
        private String name;
        private Integer energy;
        private Double price;
        private String unit;
        private String imageUrl;

        private Builder(Product product) {
            this.id = product.getId();
            this.name = product.getName();
            this.energy = product.getEnergy();
            this.price = product.getPrice();
            this.unit = product.getUnit();
            this.imageUrl = product.getImageUrl();
        }

        public Product build() {
            return new Product(id, name, energy, price, unit, imageUrl);
        }
    }
}
