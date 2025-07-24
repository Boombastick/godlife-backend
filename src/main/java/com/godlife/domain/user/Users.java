package com.godlife.domain.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class Users {

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
    private String providerId;
    @Column(name="profile_img_url")
    private String profile_img_url;
    @Column(name="created_at")
    private LocalDateTime created_at;

}
