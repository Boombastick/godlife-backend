package com.godlife.global.security.oauth.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoProfile {
    private String nickname;
    private String thumbnail_image_url;
    private String profile_image_url;
    private boolean is_default_image;
    private boolean is_default_nickname;
}
