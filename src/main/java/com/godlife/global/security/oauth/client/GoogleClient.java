package com.godlife.global.security.oauth.client;

import com.godlife.global.security.oauth.dto.response.GoogleTokenResponse;
import com.godlife.global.security.oauth.dto.response.GoogleUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class GoogleClient {

    private final RestTemplate restTemplate;

    @Value("${oauth.google.client_id}")
    private String client_id;
    @Value("${oauth.google.client_secret}")
    private String client_secret;
    @Value("${oauth.google.redirect_uri}")
    private String redirect_uri;

    public GoogleTokenResponse getAccessToken(String code, String state) {

        String url = "https://oauth2.googleapis.com/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", client_id);
        params.add("client_secret", client_secret);
        params.add("redirect_uri", redirect_uri);
        params.add("code", code);
        params.add("state", state);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<GoogleTokenResponse> response = restTemplate.postForEntity(url, request, GoogleTokenResponse.class);

        System.out.println("code : " + code);
        System.out.println("reposen.getBody()" + response.getBody().getAccess_token());
        return response.getBody();
    }

    public GoogleUserResponse getUserInfo(GoogleTokenResponse token) {
        String url = "https://www.googleapis.com/oauth2/v2/userinfo";
        HttpHeaders header = new HttpHeaders();
        header.setBearerAuth(token.getAccess_token());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(header);

        ResponseEntity<GoogleUserResponse> response =restTemplate.exchange(url, HttpMethod.GET, request, GoogleUserResponse.class);

        return response.getBody();
    }
}
