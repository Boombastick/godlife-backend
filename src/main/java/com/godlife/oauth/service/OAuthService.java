package com.godlife.oauth.service;

import com.godlife.oauth.client.NaverClient;
import com.godlife.oauth.dto.response.NaverTokenResponse;
import com.godlife.oauth.dto.response.NaverUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OAuthService {

    private final NaverClient naverClient;

    public void login(String code, String state, String provider) {
        switch (provider) {
            case "naver":
                NaverTokenResponse naverToken = naverClient.getAccessToken(code, state);
                NaverUserResponse naverUser = naverClient.getUserInfo(naverToken);
                System.out.println("naverUser: " + naverUser.getResponse().getName());
                return;
            case "google":return;
            case "kakao":return;
        }



    }
}
