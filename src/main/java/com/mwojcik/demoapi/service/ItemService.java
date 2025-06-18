package com.mwojcik.demoapi.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mwojcik.demoapi.model.Item;
import com.mwojcik.demoapi.repository.ItemRepository;
import java.util.UUID;
import java.util.List;

@Service
public class ItemService {
  @Autowired
  private ItemRepository itemRepository;
  
  public Item addItem(UUID owner_id, String name) {
    Item item = Item.builder()
            .name(name)
            .ownerId(owner_id)
            .build();
    itemRepository.save(item);
    return item;
  }

  public List<Item> getItemsByOwnerId(UUID ownerId) {
    return itemRepository.findByOwnerId(ownerId);
  }
  
}
