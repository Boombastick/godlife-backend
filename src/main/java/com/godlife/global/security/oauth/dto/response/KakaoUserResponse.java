package com.godlife.global.security.oauth.dto.response;

import com.godlife.domain.user.dto.SocialUserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class KakaoUserResponse {
    private long id;
    private boolean has_signed_up;
    private LocalDateTime connected_at;
    private LocalDateTime synced_at;
    private KakaoProperties properties;
    private KakaoAccount kakao_account;
    private String for_partner;

    public SocialUserDto toDto() {
        return SocialUserDto.builder()
                .provider("kakao")
                .provider_id(String.valueOf(id))
                .email(kakao_account.getEmail())
                .nickname(kakao_account.getProfile().getNickname())
                .profile_img_url(kakao_account.getProfile().getProfile_image_url())
                .build();
    }
}
