package com.deseteral.burgerparty.controller;

import com.deseteral.burgerparty.domain.imgur.ImgurResponse;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/images")
public class ImageController {

    @RequestMapping(method = RequestMethod.POST, consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity create(@RequestPart("image") MultipartFile file) throws IOException {
        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID IMGUI_API_KEY");

        ResponseEntity<ImgurResponse> response = rest.exchange(
            "https://api.imgur.com/3/image",
            HttpMethod.POST,
            new HttpEntity<>(file.getBytes(), headers),
            ImgurResponse.class
        );

        return created(
            URI.create(response.getBody().getData().getLink())
        ).body(response.getBody());
    }
}
