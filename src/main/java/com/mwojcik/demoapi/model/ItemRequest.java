package com.mwojcik.demoapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemRequest {
  private String name;
}
