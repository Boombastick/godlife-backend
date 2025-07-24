package com.godlife.global.security.oauth.service;

import com.godlife.domain.user.Users;
import com.godlife.domain.user.UserService;
import com.godlife.domain.user.dto.SocialUserDto;
import com.godlife.global.security.oauth.client.GoogleClient;
import com.godlife.global.security.oauth.client.KakaoClient;
import com.godlife.global.security.oauth.client.NaverClient;
import com.godlife.global.security.oauth.dto.response.*;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OAuthService {

    private final NaverClient naverClient;
    private final GoogleClient googleClient;
    private final KakaoClient kakaoClient;

    private final UserService userService;

    public Users login(String code, String state, String provider) {
        SocialUserDto socialUserDto = null;
        switch (provider) {
            case "naver":
                NaverTokenResponse naverToken = naverClient.getAccessToken(code, state);
                NaverUserResponse naverUser = naverClient.getUserInfo(naverToken);
                socialUserDto = naverUser.getResponse().toDto();
                System.out.println("naverUser: " + naverUser.getResponse().getName());
                break;
            case "google":
                GoogleTokenResponse googleToken = googleClient.getAccessToken(code, state);
                GoogleUserResponse googleUser = googleClient.getUserInfo(googleToken);
                socialUserDto = googleUser.toDto();
                System.out.println("googleUser: " + googleUser.getName());
                System.out.println("googleUser: " + googleUser);
                System.out.println("googleUser:" + googleUser.getName() +" "+googleUser.getEmail() +" "+ googleUser.getId() +" "+ googleUser.getPicture());
                break;
            case "kakao":
                KakaoTokenResponse kakaoToken = kakaoClient.getAccessToken(code, state);
                KakaoTokenInfoResponse kakaoTokenInfo = kakaoClient.getTokenInfo(kakaoToken);
                KakaoUserResponse kakaoUser = kakaoClient.getUserInfo(code, kakaoToken, kakaoTokenInfo);
                socialUserDto = kakaoUser.toDto();
                System.out.println("kakaUser: " + kakaoUser.getKakao_account().getName());
                break;
            default: throw new IllegalArgumentException("지원하지 않는 provider: " + provider);
        }

        return userService.saveSocialUserIfNew(socialUserDto);

    }
}
