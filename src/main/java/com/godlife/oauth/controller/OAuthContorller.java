package com.godlife.oauth.controller;

import com.godlife.oauth.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/oauth")
public class OAuthContorller {

    private final OAuthService oAuthService;

    @Value("${frontend.base-url}")
    private String frontBaseUrl;

    @GetMapping("/naver")
    public String naverCallback(String code, String state){

        System.out.println("naverCallback 함수 진입");
        oAuthService.login(code, state, "naver");
        return "redirect:" + frontBaseUrl;
    }

    @GetMapping("/google")
    public String googleCallback(String code, String state){
        System.out.println("googleCallback 함수 진입");
        oAuthService.login(code, state, "google");
        return "redirect:" + frontBaseUrl;
    }

    @GetMapping("/kakao")
    public String kakao(){
        return "kakao";
    }



}
