package com.example.spring_security.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ogbozoyan
 * @date 27.05.2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestDTO implements Serializable {

    private String username;
    private String password;
}
