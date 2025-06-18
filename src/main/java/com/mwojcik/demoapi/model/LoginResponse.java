package com.mwojcik.demoapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    
    private String token;
}
