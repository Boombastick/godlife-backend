package com.godlife.global.security.oauth.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class KakaoAccount {
    private boolean profile_needs_agreement;
    private boolean profile_nickname_needs_agreement;
    private boolean profile_image_needs_agreement;
    private KakaoProfile profile;
    private boolean name_needs_agreement;
    private String name;
    private boolean email_needs_agreement;
    private boolean is_email_valid;
    private String email;
    private boolean age_range_needs_agreement;
    private String age_range;
    private boolean birthyear_needs_agreement;
    private String birthyear;
    private boolean birthday_needs_agreement;
    private String birthday;
    private String brithday_type;
    private boolean is_leap_month;
    private boolean gender_needs_agreement;
    private String gender;
    private boolean phone_number_needs_agreement;
    private String phone_number;
    private boolean ci_needs_agreement;
    private String ci;
    private LocalDateTime ci_authenticated_at;

}
