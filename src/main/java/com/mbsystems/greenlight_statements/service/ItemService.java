package com.mbsystems.greenlight_statements.service;

import com.mbsystems.greenlight_statements.models.Item;
import com.mbsystems.greenlight_statements.models.Owner;
import com.mbsystems.greenlight_statements.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item saveItem(Item owner) {
        return itemRepository.save(owner);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }
}

