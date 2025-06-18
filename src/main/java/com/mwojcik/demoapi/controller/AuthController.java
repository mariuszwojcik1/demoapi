package com.mwojcik.demoapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mwojcik.demoapi.model.LoginRequest;
import com.mwojcik.demoapi.model.LoginResponse;
import com.mwojcik.demoapi.service.AuthService;
import com.mwojcik.demoapi.service.UserService;
import lombok.RequiredArgsConstructor;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
@RequiredArgsConstructor
public class AuthController {
  
  @Autowired
  private UserService userService;

  private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
      return authService.attemptLogin(request.getLogin(), request.getPassword());
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Validated LoginRequest request) {
      try {
          userService.saveUser(request.getLogin(), request.getPassword());
      } catch (DuplicateKeyException e) {
          return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
      }

      return ResponseEntity.status(HttpStatus.CREATED).body("Registering successfull");
    }
}
