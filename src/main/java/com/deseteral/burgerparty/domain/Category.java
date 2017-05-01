package com.deseteral.burgerparty.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Category {
    @Id
    private final String id;
    private final String name;

    @JsonCreator
    Category(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name
    ) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Builder builder(Category category) {
        return new Builder(category);
    }

    public static final class Builder {
        private String id;
        private String name;

        private Builder(Category category) {
            this.id = category.id;
            this.name = category.name;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Category build() {
            return new Category(id, name);
        }
    }
}
