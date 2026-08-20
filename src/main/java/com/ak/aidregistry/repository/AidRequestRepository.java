package com.ak.aidregistry.repository;

import com.ak.aidregistry.domain.AidRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AidRequestRepository {

    void save(AidRequest request);
    AidRequest findById(String id);
    List<AidRequest> findAll();
}
