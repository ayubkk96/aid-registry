package com.ak.aidregistry.repository;

import com.ak.aidregistry.domain.InventoryItem;
import com.ak.aidregistry.domain.ItemType;

import java.util.*;

public class InventoryItemRepositoryImpl implements InventoryItemRepository {
    private final Map<String, InventoryItem> store = new HashMap<>();
    @Override
    public void save(InventoryItem item) {
        store.put(item.getId(), item);
    }

    @Override
    public InventoryItem findById(String id) {
        return store.get(id);
    }

    @Override
    public List<InventoryItem> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public InventoryItem findByItemType(ItemType itemType) {
        return store.values()
                .stream()
                .filter(item -> item.getItemType() == itemType)
                .findFirst()
                .orElse(null);
    }
}
