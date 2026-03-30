package com.ak.aidregistry.controller;

import com.ak.aidregistry.dto.UpsertInventoryDto;
import com.ak.aidregistry.dto.response.InventoryRequestResponseDto;
import com.ak.aidregistry.service.AidRegistryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final AidRegistryService aidRegistryService;

    public InventoryController(AidRegistryService aidRegistryService) {
        this.aidRegistryService = aidRegistryService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InventoryRequestResponseDto getItem(@PathVariable String id) {
        return aidRegistryService.getInventoryItem(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryRequestResponseDto createItem(@RequestBody UpsertInventoryDto dto) {
        return aidRegistryService.upsertInventory(dto);
    }
}
