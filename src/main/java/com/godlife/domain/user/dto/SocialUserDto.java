package com.godlife.domain.user.dto;

import com.godlife.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SocialUserDto {
    private String provider;
    private String provider_id;
    private String email;
    private String nickname;
    private String profile_img_url;

    public User toEntity() {
        return User.builder()
                .provider(provider)
                .provider_id(provider_id)
                .email(email)
                .nickname(nickname)
                .profile_img_url(profile_img_url)
                .build();

    }
}
