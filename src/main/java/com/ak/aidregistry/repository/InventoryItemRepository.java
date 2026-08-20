package com.ak.aidregistry.repository;

import com.ak.aidregistry.domain.InventoryItem;
import com.ak.aidregistry.domain.ItemType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryItemRepository {

    void save(InventoryItem item);
    InventoryItem findById(String id);
    List<InventoryItem> findAll();
    InventoryItem findByItemType(ItemType itemType);
}
