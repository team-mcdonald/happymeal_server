package com.happymeal_server.global.annotation;

import com.happymeal_server.domain.user.domain.types.UserRole;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthenticationCheck {

    UserRole[] roles() default {UserRole.CONSUMER, UserRole.PROVIDER};
}
