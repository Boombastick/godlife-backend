package com.godlife.domain.user;

import com.godlife.domain.user.dto.SocialUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveSocialUserIfNew(SocialUserDto dto) {
        return userRepository.findByProviderAndProviderId(dto.getProvider(), dto.getProvider_id())
                .orElseGet(() -> {
                    User newUser = User.builder()
                            .provider(dto.getProvider())
                            .provider_id(dto.getProvider_id())
                            .email(dto.getEmail())
                            .nickname(dto.getNickname())
                            .profile_img_url(dto.getProfile_img_url())
                            .build();
                    return userRepository.save(newUser);
                });
    }

}
