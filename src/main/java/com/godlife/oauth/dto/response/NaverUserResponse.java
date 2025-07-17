package com.godlife.oauth.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NaverUserResponse {
    private String resultcode;
    private String message;
    private NaverUser response;
}
