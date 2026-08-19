package com.ak.aidregistry.dto;

import com.ak.aidregistry.domain.ItemType;

public class UpsertInventoryDto {
    private final String id;
    private final ItemType itemType;
    private final int quantityAvailable;

    public UpsertInventoryDto(String id, ItemType itemType, int quantityAvailable) {
        this.id = id;
        this.itemType = itemType;
        this.quantityAvailable = quantityAvailable;
    }

    public String getId() {
        return id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }
}
