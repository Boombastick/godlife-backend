package com.godlife.oauth.controller;

import com.godlife.oauth.dto.response.UserNaverResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/oauth")
public class OAuthContorller {

    @RequestMapping("/naver")
    public String naverCallback(UserNaverResponse userNaverResponse){

        return "naver";
    }

    @RequestMapping("/google")
    public String google(){
        return "google";
    }

    @RequestMapping("/kakao")
    public String kakao(){
        return "kakao";
    }



}
