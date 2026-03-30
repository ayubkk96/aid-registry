package com.ak.aidregistry.controller;

import com.ak.aidregistry.dto.MatchResultDto;
import com.ak.aidregistry.dto.response.InventoryRequestResponseDto;
import com.ak.aidregistry.service.AidRegistryService;
import com.ak.aidregistry.service.MatchingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchingController {

    private final AidRegistryService aidRegistryService;

    public MatchingController(AidRegistryService aidRegistryService) {
        this.aidRegistryService = aidRegistryService;
    }

    @PostMapping("/run")
    @ResponseStatus(HttpStatus.OK)
    public MatchResultDto runMatching() {
        return aidRegistryService.runMatching();
    }
}
