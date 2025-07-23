package com.godlife.global.security.oauth.client;

import com.godlife.global.security.oauth.dto.response.NaverTokenResponse;
import com.godlife.global.security.oauth.dto.response.NaverUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class NaverClient {

    private final RestTemplate restTemplate;

    @Value("${oauth.naver.client_id}")
    private String client_id;
    @Value("${oauth.naver.client_secret}")
    private String client_secret;

    public NaverTokenResponse getAccessToken(String code, String state) {

        String url = "https://nid.naver.com/oauth2.0/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", client_id);
        params.add("client_secret", client_secret);
        params.add("code", code);
        params.add("state", state);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);

        ResponseEntity<NaverTokenResponse> response = restTemplate.postForEntity(
                url,requestEntity,NaverTokenResponse.class
        );


        return response.getBody();
    }

    public NaverUserResponse getUserInfo(NaverTokenResponse naverToken) {
        String url = "https://openapi.naver.com/v1/nid/me";
        String authorization = naverToken.getAccess_token();

        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", "Bearer " + authorization);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<NaverUserResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                NaverUserResponse.class
        );
        return response.getBody();
    }
}
