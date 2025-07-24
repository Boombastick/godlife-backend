package com.godlife.domain.user;

import com.godlife.domain.user.dto.SocialUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Users saveSocialUserIfNew(SocialUserDto dto) {
        return userRepository.findByProviderAndProviderId(dto.getProvider(), dto.getProviderId())
                .orElseGet(() -> {
                    Users newUsers = Users.builder()
                            .provider(dto.getProvider())
                            .providerId(dto.getProviderId())
                            .email(dto.getEmail())
                            .nickname(dto.getNickname())
                            .profile_img_url(dto.getProfile_img_url())
                            .created_at(LocalDateTime.now())
                            .build();
                    return userRepository.save(newUsers);
                });
    }

}
