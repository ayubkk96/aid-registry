package com.ak.aidregistry.controller;

import com.ak.aidregistry.dto.CreateAidRequestDto;
import com.ak.aidregistry.dto.response.AidRequestResponseDto;
import com.ak.aidregistry.service.AidRegistryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
public class AidRequestController {
    private final AidRegistryService aidRegistryService;

    public AidRequestController(AidRegistryService aidRegistryService) {
        this.aidRegistryService = aidRegistryService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AidRequestResponseDto getAidRequest(@PathVariable String id) {
        return aidRegistryService.getAidRequest(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AidRequestResponseDto createAidRequest(@RequestBody CreateAidRequestDto dto) {
        return aidRegistryService.createAidRequest(dto);
    }

}