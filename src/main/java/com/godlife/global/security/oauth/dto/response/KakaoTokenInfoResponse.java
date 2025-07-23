package com.godlife.global.security.oauth.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoTokenInfoResponse {
    private long id;
    private int expires_in;
    private int app_id;
}
