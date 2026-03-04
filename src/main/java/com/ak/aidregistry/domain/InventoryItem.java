package com.ak.aidregistry.domain;

import io.micrometer.common.util.StringUtils;

public class InventoryItem {
    private final String id;
    private final ItemType itemType;
    private int quantityAvailable;

    public InventoryItem(String id, ItemType itemType, int quantityAvailable) {
        if (itemType == null) throw new IllegalArgumentException("Invalid item type");
        if (quantityAvailable < 0) throw new IllegalArgumentException("Invalid quantity available");
        if (id == null || StringUtils.isBlank(id)) throw new IllegalArgumentException("Invalid inventory item id");
        this.id = id;
        this.itemType = itemType;
        this.quantityAvailable = quantityAvailable;
    }

    public void reduceQuantity(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Reduction amount must be more than 0");
        }

        if (amount > quantityAvailable) {
            throw new IllegalArgumentException("Cannot reduce item quantity more than available");
        }
        this.quantityAvailable -= amount;
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
