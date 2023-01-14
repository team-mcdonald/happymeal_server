package com.happymeal_server.domain.user.domain;

import com.happymeal_server.domain.user.domain.types.UserRole;
import com.happymeal_server.global.jpa.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Table(name = "tbl_user")
@Entity
public class User extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @Column(length = 11, nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Builder
    public User(String name, String email, String phone, UserRole role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }
}
