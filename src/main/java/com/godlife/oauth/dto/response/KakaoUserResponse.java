package com.godlife.oauth.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class KakaoUserResponse {
    private long id;
    private boolean has_signed_up;
    private LocalDateTime connected_at;
    private LocalDateTime synched_at;
    private KakaoProperties properties;
    private KakaoAccount kakao_account;
    private String for_partner;

}
