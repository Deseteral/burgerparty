package com.deseteral.burgerparty.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

public class Recipe {
    @Id
    private final String id;
    private final String title;
    private final String category;
    private final String imageUrl;

    @Indexed
    private final List<Product> products;

    private final String description;
    private final Integer timeToPrepare;
    private final String difficulty;
    private final Integer portions;

    @JsonCreator
    Recipe(
        @JsonProperty("id") String id,
        @JsonProperty("title") String title,
        @JsonProperty("category") String category,
        @JsonProperty("imageUrl") String imageUrl,
        @JsonProperty("products") List<Product> products,
        @JsonProperty("description") String description,
        @JsonProperty("timeToPrepare") Integer timeToPrepare,
        @JsonProperty("difficulty") String difficulty,
        @JsonProperty("portions") Integer portions
    ) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.imageUrl = imageUrl;
        this.products = products;
        this.description = description;
        this.timeToPrepare = timeToPrepare;
        this.difficulty = difficulty;
        this.portions = portions;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getDescription() {
        return description;
    }

    public Integer getTimeToPrepare() {
        return timeToPrepare;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Integer getPortions() {
        return portions;
    }

    public static Builder builder(Recipe recipe) {
        return new Builder(recipe);
    }

    public static final class Builder {
        private String id;
        private String title;
        private String category;
        private String imageUrl;
        private List<Product> products;
        private String description;
        private Integer timeToPrepare;
        private String difficulty;
        private Integer portions;

        private Builder(Recipe recipe) {
            this.id = recipe.getId();
            this.title = recipe.getTitle();
            this.category = recipe.getCategory();
            this.imageUrl = recipe.getImageUrl();
            this.products = recipe.getProducts();
            this.description = recipe.getDescription();
            this.timeToPrepare = recipe.getTimeToPrepare();
            this.difficulty = recipe.getDifficulty();
            this.portions = recipe.getPortions();
        }

        public Recipe build() {
            return new Recipe(id, title, category, imageUrl, products, description, timeToPrepare, difficulty, portions);
        }
    }
}
