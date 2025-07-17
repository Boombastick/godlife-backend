package com.godlife.oauth.dto.response;

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
}
