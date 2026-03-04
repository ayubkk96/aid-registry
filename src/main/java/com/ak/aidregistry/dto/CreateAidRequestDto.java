package com.ak.aidregistry.dto;

import com.ak.aidregistry.domain.ItemType;

public class CreateAidRequestDto {
    private final String id;
    private final ItemType itemType;
    private final int quantity;

    public CreateAidRequestDto(String id, ItemType itemType, int quantity) {
        this.id = id;
        this.itemType = itemType;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getQuantity() {
        return quantity;
    }
}
