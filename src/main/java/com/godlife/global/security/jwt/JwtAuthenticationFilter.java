package com.godlife.global.security.jwt;

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;
import com.godlife.domain.user.UserRepository;
import com.godlife.domain.user.Users;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
        throws ServletException, IOException {

        String token = jwtProvider.resolveToken(request);

        if (token != null && jwtProvider.validateToken(token)) {
            Long userId = jwtProvider.getUserIdFromToken(token);
            Users users = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("사용자 없음"));

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(users, null, List.of());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
