package com.matt1479.inmemoryrestitems;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// A controller is used for handling HTTP requests
@RestController
public class ItemController {
    
    private final Map<Long, Item> itemRepository = new HashMap<Long, Item>();
    private final AtomicLong counter = new AtomicLong(1);

    public ItemController() { }

    @GetMapping("/items")
    public Collection<Item> getAllItems() {
        return itemRepository.values();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        Item item = itemRepository.get(id);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(item);
    }

    @PostMapping("/items")
    public Item createItem(@RequestBody Item item) {
        Long id = counter.getAndIncrement();
        item.setId(id);
        itemRepository.put(id, item);
        return item;
    }
    
    @PutMapping("/items/{id}")
    public Item replaceItem(@RequestBody Item newItem, @PathVariable Long id) {
        if (!itemRepository.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
        newItem.setId(id);
        itemRepository.put(id, newItem);
        return newItem;
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.remove(id);
    }

}
