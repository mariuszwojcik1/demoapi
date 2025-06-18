package com.mwojcik.demoapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {
    private final String login;
    private final String password;
}
