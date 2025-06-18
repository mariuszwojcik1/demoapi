package com.mwojcik.demoapi.service;

import com.mwojcik.demoapi.model.User;
import com.mwojcik.demoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.dao.DuplicateKeyException;



@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                new ArrayList<>()
            );
        }



    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void saveUser(String login, String password) throws DuplicateKeyException {
        if (userRepository.findByLogin(login) != null) {
            throw new DuplicateKeyException("User already exists: " + login);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String encryptedPasswordString = encoder.encode(password);
        User user = User.builder()
            .login(login)
            .password(encryptedPasswordString)
            .build();
        userRepository.save(user);
    }

    public List<User> list() {
        return userRepository.findAll();
    }
}

