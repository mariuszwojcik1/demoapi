package com.mwojcik.demoapi.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.UUID;
import java.util.List;

@Component
public class JwtToPrincipalConverter {
    public UserPrincipal convert(DecodedJWT jwt) {
        var authorityList = getClaimOrEmptyList(jwt, "au").stream()
                .map(SimpleGrantedAuthority::new)
                .toList();

        return UserPrincipal.builder()
                .userId( jwt.getSubject() != null ? UUID.fromString(jwt.getSubject()) : null )
                .login( jwt.getClaim("l").asString() )
                .authorities( authorityList )
                .build();
    }

    private List<String> getClaimOrEmptyList(DecodedJWT jwt, String claim) {
        if (jwt.getClaim(claim).isNull()) return List.of();
        return jwt.getClaim(claim).asList(String.class);
    }
}
