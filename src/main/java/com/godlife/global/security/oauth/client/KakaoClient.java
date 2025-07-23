package com.godlife.global.security.oauth.client;

import com.godlife.global.security.oauth.dto.response.KakaoTokenInfoResponse;
import com.godlife.global.security.oauth.dto.response.KakaoTokenResponse;
import com.godlife.global.security.oauth.dto.response.KakaoUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class KakaoClient {

    private final RestTemplate restTemplate;

    @Value("${oauth.kakao.client_id}")
    private String client_id;
    @Value("${oauth.kakao.client_secret}")
    private String client_secret;
    @Value("${oauth.kakao.redirect_uri}")
    private String redirect_uri;

    public KakaoTokenResponse getAccessToken(String code, String state) {
        String url = "https://kauth.kakao.com/oauth/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", client_id);
        params.add("client_secret", client_secret);
        params.add("redirect_uri", redirect_uri);
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<KakaoTokenResponse> response = restTemplate.postForEntity(url, request, KakaoTokenResponse.class);
        return response.getBody();
    }

    public KakaoTokenInfoResponse getTokenInfo(KakaoTokenResponse token) {
        String url = "https://kapi.kakao.com/v1/user/access_token_info";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token.getAccess_token());
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<KakaoTokenInfoResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, KakaoTokenInfoResponse.class);

        return response.getBody();
    }

    public KakaoUserResponse getUserInfo(String code, KakaoTokenResponse token, KakaoTokenInfoResponse tokenInfo) {
        String url = "https://kapi.kakao.com/v2/user/me";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBearerAuth(token.getAccess_token());

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("target_id_type", "user_id");
        params.add("target_id", tokenInfo.getId());

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(params, headers);

        ResponseEntity<KakaoUserResponse> response = restTemplate.postForEntity(url, request, KakaoUserResponse.class);

        return response.getBody();
    }
}
