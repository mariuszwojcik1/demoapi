package com.mwojcik.demoapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.mwojcik.demoapi.security.UserPrincipal;
import java.util.List;

import com.mwojcik.demoapi.model.Item;
import com.mwojcik.demoapi.model.ItemRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mwojcik.demoapi.service.ItemService;


@RestController
public class ItemController {
  
  @Autowired
  private ItemService itemService;

  @GetMapping("/items")
  public List<Item> get_items(@AuthenticationPrincipal UserPrincipal principal) {
    return itemService.getItemsByOwnerId(principal.getUserId());
  }

  @PostMapping("/items")
  public ResponseEntity<String> postMethodName(@AuthenticationPrincipal UserPrincipal principal,@RequestBody ItemRequest itemRequest) {

      itemService.addItem(
          principal.getUserId(),
          itemRequest.getName()
      );
      return ResponseEntity.status(HttpStatus.CREATED).body("Item created successfull");
  }
  
}
