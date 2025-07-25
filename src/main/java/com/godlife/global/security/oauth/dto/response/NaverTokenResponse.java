package com.godlife.global.security.oauth.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NaverTokenResponse {
    private String access_token;
    private String refresh_token;
    private String token_type;
    private int expires_in;
    private String error;
    private String error_description;
}
