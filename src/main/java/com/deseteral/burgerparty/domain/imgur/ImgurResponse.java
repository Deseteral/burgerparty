package com.deseteral.burgerparty.domain.imgur;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImgurResponse {
    private final ImgurData data;

    ImgurResponse(@JsonProperty("data") ImgurData data) {
        this.data = data;
    }

    public ImgurData getData() {
        return data;
    }
}
