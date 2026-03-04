package com.ak.aidregistry.controller;

import com.ak.aidregistry.dto.CreateAidRequestDto;
import com.ak.aidregistry.dto.response.AidRequestResponseDto;
import com.ak.aidregistry.service.AidRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AidRequestController {

    @Autowired
    AidRegistryService aidRegistryService;

    @PostMapping("/requests")
    public AidRequestResponseDto createRequest(@RequestBody CreateAidRequestDto dto) {
        return aidRegistryService.createRequest(dto);
    }

}