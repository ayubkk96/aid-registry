package com.ak.aidregistry.service;

import com.ak.aidregistry.domain.AidRequest;
import com.ak.aidregistry.domain.AidRequestStatus;
import com.ak.aidregistry.domain.InventoryItem;
import com.ak.aidregistry.domain.ItemType;

import java.util.Map;


public class MatchingService {
    public boolean match(AidRequest request, InventoryItem inventory){
        if (inventory == null) throw new IllegalArgumentException("inventory is null");
        if (request == null) throw new IllegalArgumentException("request is null");
        if (request.getStatus() == AidRequestStatus.OPEN
                && inventory.getItemType() == request.getItemType()
                && inventory.getQuantityAvailable() >= request.getQuantity()) {
            inventory.reduceQuantity(request.getQuantity());
            request.allocate();
            return true;
        }
        return false;
    }
}
