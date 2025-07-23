package com.godlife.domain.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="email", nullable = false, unique = true)
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="nickname")
    private String nickname;
    @Column(name="provider")
    private String provider;
    @Column(name="provider_id")
    private String provider_id;
    @Column(name="profile_img_url")
    private String profile_img_url;
    @Column(name="create_at")
    private LocalDateTime created_at;

}
