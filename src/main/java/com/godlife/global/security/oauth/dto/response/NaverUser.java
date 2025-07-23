package com.godlife.global.security.oauth.dto.response;

import com.godlife.domain.user.dto.SocialUserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NaverUser {
    private String id;
    private String email;
    private String name;
    private String nickname;
    private String profile_image;
    private String age;
    private String gender;
    private String mobile;
    private String birthyear;
    private String birthday;

    public SocialUserDto toDto() {
        return SocialUserDto.builder()
                .provider("naver")
                .provider_id(id)
                .email(email)
                .nickname(nickname)
                .profile_img_url(profile_image)
                .build();
    }
}
