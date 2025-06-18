package com.mwojcik.demoapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.transaction.annotation.Transactional;

import com.mwojcik.demoapi.model.User;
import com.mwojcik.demoapi.service.UserService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@AutoConfigureMockMvc
public class AuthControllerTest {
  @Autowired
    private MockMvc api;

  @Autowired
  private UserService userService;

  @Test
  public void testRegister() throws Exception {
    api.perform(post("/register")
            .contentType("application/json")
            .content("{\"login\":\"newTestUser\", \"password\":\"newpassword\"}"))
        .andExpect(status().isCreated())
        .andExpect(content().string("Registering successfull"));
  }

@Test
  public void testLogin() throws Exception {
    
    userService.saveUser("newTestUserLogin", "password");
    api.perform(post("/login")
            .contentType("application/json")
            .content("{\"login\":\"newTestUserLogin\", \"password\":\"password\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"));
  }
}
