package com.ak.aidregistry.dto;

import com.ak.aidregistry.domain.AidRequest;
import com.ak.aidregistry.domain.InventoryItem;

public class MatchResultDto {
    private final int allocatedCount;
    private final int skippedNotOpenCount;
    private final int noInventoryTypeCount;
    private final int insufficientStockCount;

    public MatchResultDto(int allocatedCount, int skippedNotOpenCount, int noInventoryTypeCount, int insufficientStockCount) {
        this.allocatedCount = allocatedCount;
        this.skippedNotOpenCount = skippedNotOpenCount;
        this.noInventoryTypeCount = noInventoryTypeCount;
        this.insufficientStockCount = insufficientStockCount;
    }

    public int getAllocatedCount() {
        return allocatedCount;
    }

    public int getSkippedNotOpenCount() {
        return skippedNotOpenCount;
    }

    public int getNoInventoryTypeCount() {
        return noInventoryTypeCount;
    }

    public int getInsufficientStockCount() {
        return insufficientStockCount;
    }
}
