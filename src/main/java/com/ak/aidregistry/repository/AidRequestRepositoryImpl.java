package com.ak.aidregistry.repository;

import com.ak.aidregistry.domain.AidRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AidRequestRepositoryImpl implements AidRequestRepository {
    private final Map<String, AidRequest> store = new HashMap<>();
    @Override
    public void save(AidRequest request) {
        store.put(request.getId(), request);
    }

    @Override
    public AidRequest findById(String id) {
        return store.get(id);
    }

    @Override
    public List<AidRequest> findAll() {
        return new ArrayList<>(store.values());
    }

}
