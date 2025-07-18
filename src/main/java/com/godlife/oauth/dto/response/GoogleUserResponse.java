package com.godlife.oauth.dto.response;

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
}
