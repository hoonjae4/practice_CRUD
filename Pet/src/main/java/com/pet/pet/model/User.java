package com.pet.pet.model;

import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;

    @NotBlank(message = "ID 입력은 필수입니다.")
    @Column(name="username", length = 100, unique = true)
    private String username;

    @NotBlank(message = "Name 입력은 필수입니다.")
    @Column(name="name", length = 20, unique = true)
    private String name;

    @NotBlank(message = "Password 입력은 필수입니다.")
    @Column(name = "password", length = 255)
    private String password;

    @NotBlank
    @Column(name="address", length= 100)
    private String address;
}
