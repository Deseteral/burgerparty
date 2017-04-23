package com.deseteral.burgerparty.domain.imgur;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImgurData {
    private final String link;

    ImgurData(@JsonProperty("link") String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
