package com.ak.aidregistry.service;

import com.ak.aidregistry.domain.AidRequest;
import com.ak.aidregistry.dto.CreateAidRequestDto;
import com.ak.aidregistry.dto.response.AidRequestResponseDto;
import org.springframework.stereotype.Service;

@Service
public class AidRegistryService {

//    public AidRequestResponseDto getAidRequest(String id) {
//        AidRequest request = repository.findById(id);
//
//        return new AidRequestResponseDto(
//                request.getId(),
//                request.getItemType(),
//                request.getQuantity(),
//                request.getStatus()
//        );
//    }

    public AidRequestResponseDto createAidRequest(CreateAidRequestDto dto) {
        AidRequest aidRequest = new AidRequest(dto.getId(), dto.getItemType(), dto.getQuantity());
        //repository.save(request);
        return new AidRequestResponseDto(aidRequest.getId(), aidRequest.getItemType(),
                aidRequest.getQuantity(), aidRequest.getStatus()
        );
    }

    //Upsert means update if exists, otherwise insert (create) it
    public void upsertInventory(){

    }
    public void listRequests(){

    }
    public void listInventory(){

    }
    public void runMatching() {

    }
}
