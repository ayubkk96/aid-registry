package com.ak.aidregistry.repository;

import com.ak.aidregistry.domain.AidRequest;
import com.ak.aidregistry.domain.InventoryItem;

public interface AidRequestRepository {

    void save(AidRequest request);
    AidRequest findById(String id);
}
