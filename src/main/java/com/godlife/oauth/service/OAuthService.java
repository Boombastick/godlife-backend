package com.godlife.oauth.service;

import com.godlife.oauth.client.GoogleClient;
import com.godlife.oauth.client.NaverClient;
import com.godlife.oauth.dto.response.GoogleTokenResponse;
import com.godlife.oauth.dto.response.GoogleUserResponse;
import com.godlife.oauth.dto.response.NaverTokenResponse;
import com.godlife.oauth.dto.response.NaverUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OAuthService {

    private final NaverClient naverClient;
    private final GoogleClient googleClient;

    public void login(String code, String state, String provider) {
        switch (provider) {
            case "naver":
                NaverTokenResponse naverToken = naverClient.getAccessToken(code, state);
                NaverUserResponse naverUser = naverClient.getUserInfo(naverToken);
                System.out.println("naverUser: " + naverUser.getResponse().getName());
                return;
            case "google":
                GoogleTokenResponse googleToken = googleClient.getAccessToken(code, state);
                GoogleUserResponse googleUser = googleClient.getUserInfo(googleToken);
                System.out.println("googleUser: " + googleUser.getName());
                return;
            case "kakao":return;
        }



    }
}
