package com.gym_backend.dao.request;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SigninRequest {
    private String email;
    private String password;
}
