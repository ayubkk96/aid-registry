package com.ak.aidregistry.domain;

import com.ak.aidregistry.exceptions.InvalidItemException;
import com.ak.aidregistry.exceptions.InvalidQuantityAmountException;
import com.ak.aidregistry.exceptions.InvalidStatusChangeException;
import io.micrometer.common.util.StringUtils;

public class AidRequest {
    private final String id;
    private final ItemType itemType;
    private final int quantity;
    private AidRequestStatus status;


    public AidRequest(String id, ItemType itemType, int quantity) {
        if (id == null || StringUtils.isBlank(id)) throw new IllegalArgumentException("Invalid item id");
        if (itemType == null) {
            throw new InvalidItemException("itemType cannot be null or blank");
        }
        if(quantity <= 0) {
            throw new InvalidQuantityAmountException("quantity must be greater than zero");
        }
        this.id = id;
        this.itemType = itemType;
        this.quantity = quantity;
        this.status = AidRequestStatus.OPEN;
    }

    public void allocate() {
        if(status == AidRequestStatus.ALLOCATED) {
            return;
        }
        if (status == AidRequestStatus.OPEN) {
            this.status = AidRequestStatus.ALLOCATED;
        }
        else {
            throw new InvalidStatusChangeException("Cannot allocate a non-open AidRequest");
        }
    }

    public void deliver() {
        if (status == AidRequestStatus.DELIVERED) {
            return;
        }
        if (status == AidRequestStatus.ALLOCATED) {
            this.status = AidRequestStatus.DELIVERED;
        }
        else {
            throw new InvalidStatusChangeException("Cannot deliver a non-allocated AidRequest");
        }
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

    public AidRequestStatus getStatus() {
        return status;
    }
}
