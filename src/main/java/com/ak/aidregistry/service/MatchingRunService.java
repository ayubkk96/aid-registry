package com.ak.aidregistry.service;

import com.ak.aidregistry.domain.AidRequest;
import com.ak.aidregistry.domain.AidRequestStatus;
import com.ak.aidregistry.domain.InventoryItem;
import com.ak.aidregistry.domain.ItemType;
import com.ak.aidregistry.dto.MatchResultDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchingRunService {

    private final MatchingService matchingService;

    public MatchingRunService(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    public MatchResultDto run(List<AidRequest> requests, List<InventoryItem> inventoryList){
        int allocated = 0;
        int skippedNotOpen = 0;
        int noInventoryType = 0;
        int insufficientStock = 0;

        Map<ItemType, InventoryItem> inventoryMap = inventoryList.stream()
                .collect(Collectors.toMap(
                        InventoryItem::getItemType, i -> i
                ));

        for(AidRequest request : requests) {
            if (request.getStatus() != AidRequestStatus.OPEN){
                skippedNotOpen++;
                continue;
            }

            InventoryItem item = inventoryMap.get(request.getItemType());
            if (item == null) {
                noInventoryType++;
                continue;
            }

            if (item.getQuantityAvailable() < request.getQuantity()) {
                insufficientStock++;
                continue;
            }

            if(MatchingService.match(request, item)); {
                allocated++;
            }
        }
        return new MatchResultDto(
                allocated,
                skippedNotOpen,
                noInventoryType,
                insufficientStock
        );
    }
}
