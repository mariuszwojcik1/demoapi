package com.mwojcik.demoapi.controller;

import com.mwojcik.demoapi.security.UserPrincipal;
import com.mwojcik.demoapi.security.UserPrincipalAuthenticationToken;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.List;
import java.util.UUID;

public class WithMockUserSecurityContextFactory implements WithSecurityContextFactory<WithMockUser> {
    @Override
    public SecurityContext createSecurityContext(WithMockUser annotation) {
        var authorities = List.of(new SimpleGrantedAuthority("user"));

        var principal = UserPrincipal.builder()
                .userId(UUID.randomUUID())
                .login(annotation.login())
                .authorities(authorities)
                .build();
        System.out.println("Creating mock user with login: " + principal.getLogin() + " and authorities: " + principal.getAuthorities());
        var context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(new UserPrincipalAuthenticationToken(principal));    
        return context;
    }
}
