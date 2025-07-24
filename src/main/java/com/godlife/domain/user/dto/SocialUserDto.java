package com.godlife.domain.user.dto;

import com.godlife.domain.user.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SocialUserDto {
    private String provider;
    private String providerId;
    private String email;
    private String nickname;
    private String profile_img_url;

    public Users toEntity() {
        return Users.builder()
                .provider(provider)
                .providerId(providerId)
                .email(email)
                .nickname(nickname)
                .profile_img_url(profile_img_url)
                .build();

    }
}
