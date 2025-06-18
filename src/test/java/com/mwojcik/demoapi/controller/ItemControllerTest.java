package com.mwojcik.demoapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ItemControllerTest {
  @Autowired
    private MockMvc api;

  @Test
  @WithMockUser
  public void testAddItem() throws Exception {
    api.perform(post("/items")
            .contentType("application/json")
            .content("{\"name\":\"NewItem\"}"))
        .andExpect(status().isCreated())
        .andExpect(content().string("Item created successfull"));
  }

@Test
  @WithMockUser
  public void testGetItems() throws Exception {
    api.perform(get("/items"))
                  .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"));
  }

}
