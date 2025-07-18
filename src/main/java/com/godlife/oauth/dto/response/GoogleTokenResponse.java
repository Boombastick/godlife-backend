package com.godlife.oauth.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleTokenResponse {
    private String access_token;
    private int expires_in;
    private String refresh_token;
    private int refresh_token_expires_in;
    private String scope;
    private String token_type;

}
