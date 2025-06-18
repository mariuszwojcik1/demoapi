package com.mwojcik.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mwojcik.demoapi.model.Item;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

  Item findByName(String name);
  List<Item> findByOwnerId(UUID ownerId);
  
}
