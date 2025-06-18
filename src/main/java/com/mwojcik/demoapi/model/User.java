package com.mwojcik.demoapi.model;

import jakarta.persistence.*;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    
    // Implementation of UserDetails methods
    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return Collections.emptyList(); // No roles implemented in this example
    // }

    // @Override
    // public String getUsername() {
    //     return login;
    // }

    // @Override
    // public boolean isAccountNonExpired() { return true; }
    // @Override
    // public boolean isAccountNonLocked() { return true; }
    // @Override
    // public boolean isCredentialsNonExpired() { return true; }
    // @Override
    // public boolean isEnabled() { return true; }
}
