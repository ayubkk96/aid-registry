package com.ak.aidregistry.service;

import com.ak.aidregistry.domain.AidRequest;
import com.ak.aidregistry.domain.InventoryItem;
import com.ak.aidregistry.dto.CreateAidRequestDto;
import com.ak.aidregistry.dto.MatchResultDto;
import com.ak.aidregistry.dto.UpsertInventoryDto;
import com.ak.aidregistry.dto.response.AidRequestResponseDto;
import com.ak.aidregistry.dto.response.InventoryRequestResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AidRegistryService {

    private final MatchingRunService matchingRunService;

    public AidRegistryService(MatchingRunService matchingRunService) {
        this.matchingRunService = matchingRunService;
    }

    public AidRequestResponseDto getAidRequest(String id) {
        AidRequest request = repository.findById(id);
        return new AidRequestResponseDto(
                request.getId(),
                request.getItemType(),
                request.getQuantity(),
                request.getStatus()
        );
    }

    public AidRequestResponseDto createAidRequest(CreateAidRequestDto dto) {
        AidRequest aidRequest = new AidRequest(dto.getId(), dto.getItemType(), dto.getQuantity());
        repository.save(aidRequest);
        return new AidRequestResponseDto(
                aidRequest.getId(),
                aidRequest.getItemType(),
                aidRequest.getQuantity(),
                aidRequest.getStatus()
        );
    }

    public InventoryRequestResponseDto getInventoryItem(String id) {
        InventoryItem request = repository.findById(id);
        return new InventoryRequestResponseDto(
                request.getId(),
                request.getItemType(),
                request.getQuantityAvailable()
        );
    }

    //Upsert means update if exists, otherwise insert (create) it
    public InventoryRequestResponseDto upsertInventory(UpsertInventoryDto dto){
        InventoryItem existing = repository.findById(dto.getId());

        if(existing != null) {
            existing.increaseQuantity(dto.getQuantityAvailable());
            return new InventoryRequestResponseDto(
                    existing.getId(),
                    existing.getItemType(),
                    existing.getQuantityAvailable()
            );
        }

        InventoryItem inventoryItem = new InventoryItem(
                dto.getId(),
                dto.getItemType(),
                dto.getQuantityAvailable());
        repository.save(inventoryItem);
        return new InventoryRequestResponseDto(
                inventoryItem.getId(),
                inventoryItem.getItemType(),
                inventoryItem.getQuantityAvailable()
        );
    }
    public void listRequests(){

    }
    public void listInventory(){

    }
    public MatchResultDto runMatching() {
        List<AidRequest> requests = requestRepository.findAll();
        List<InventoryItem> inventory = inventoryRepository.findAll();

        return matchingRunService.run(requests, inventory);
    }
}
