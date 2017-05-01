package com.deseteral.burgerparty.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {
    private final Integer status;
    private final String message;

    @JsonCreator
    Error(
        @JsonProperty("status") Integer status,
        @JsonProperty("message") String message
    ) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static Builder builder(Error error) {
        return new Builder(error);
    }

    public static final class Builder {
        private Integer status;
        private String message;

        public Builder() {
            this.status = 200;
            this.message = "";
        }

        public Builder(Error error) {
            this.status = error.getStatus();
            this.message = error.getMessage();
        }

        public Builder withStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Error build() {
            return new Error(status, message);
        }
    }
}
