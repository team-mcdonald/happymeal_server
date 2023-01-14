package com.happymeal_server.global.interceptor;

import com.happymeal_server.domain.user.domain.User;
import com.happymeal_server.domain.user.domain.types.UserRole;
import com.happymeal_server.global.annotation.AuthenticationCheck;
import com.happymeal_server.global.error.exception.InvalidPermissionException;
import com.happymeal_server.global.error.exception.InvalidTokenException;
import com.happymeal_server.global.lib.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        AuthenticationCheck authenticationCheck = handlerMethod.getMethodAnnotation(AuthenticationCheck.class);

        if (authenticationCheck == null) {
            return true;
        }

        String token = jwtUtil.extract(request, "Bearer");

        if (token == null || token.length() == 0) {
            throw InvalidTokenException.EXCEPTION;
        }

        User user = jwtUtil.validateToken(token);
        request.setAttribute("user", user);

        List<UserRole> roleList = Arrays.stream(authenticationCheck.roles()).collect(Collectors.toList());
        boolean haveAllowedRole = false;

        for (UserRole role : roleList) {
            if (user.getRole().equals(role)) {
                haveAllowedRole = true;
                break;
            }
        }

        if (!haveAllowedRole) {
            throw InvalidPermissionException.EXCEPTION;
        }

        return true;
    }
}
