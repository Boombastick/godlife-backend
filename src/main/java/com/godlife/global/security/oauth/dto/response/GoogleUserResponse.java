package com.godlife.global.security.oauth.dto.response;

import com.godlife.domain.user.dto.SocialUserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleUserResponse {
    private String id;
    private String email;
    private String verified_email;
    private String name;
    private String given_name;
    private String familly_name;
    private String picture;
    private String locale;

    public SocialUserDto toDto() {
        return SocialUserDto.builder()
                .provider("google")
                .provider_id(id)
                .email(email)
                .nickname(name)
                .profile_img_url(picture)
                .build();
    }
}
