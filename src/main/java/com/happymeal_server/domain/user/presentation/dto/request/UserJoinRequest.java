package com.happymeal_server.domain.user.presentation.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.happymeal_server.domain.user.domain.types.UserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserJoinRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    @NotNull
    private UserRole role;
}
