package com.godlife.global.security.oauth.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoTokenResponse {
    private String token_type;
    private String access_token;
    private String id_token;
    private String expires_in;
    private String refresh_token;
    private String refresh_token_expires_in;
    private String scope;
}
