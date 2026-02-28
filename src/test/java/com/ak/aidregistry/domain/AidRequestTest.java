package com.ak.aidregistry.domain;

import com.ak.aidregistry.exceptions.InvalidQuantityAmountException;
import com.ak.aidregistry.exceptions.InvalidStatusChangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AidRequestTest {
    @Test
    public void whenAidCreated_StatusIsOpen() {
        AidRequest aidRequest = new AidRequest("1", ItemType.ADULT_FEMALE_CLOTHES, 3);
        Assertions.assertEquals(AidRequestStatus.OPEN, aidRequest.getStatus());
    }

    @Test
    public void whenQuantityInvalid_ThrowInvalidQuantityException() {
        Assertions.assertThrows(InvalidQuantityAmountException.class,
                () -> new AidRequest("1", ItemType.ADULT_FEMALE_CLOTHES, -1));
    }

    @Test
    public void whenRequestOpen_ChangeStatusToAllocated() {
        AidRequest aidRequest = new AidRequest("1", ItemType.ADULT_FEMALE_CLOTHES, 3);
        aidRequest.allocate();
        Assertions.assertEquals(AidRequestStatus.ALLOCATED, aidRequest.getStatus());
    }

    @Test
    public void whenRequestOpen_ChangeStatusToDelivered_ThrowsInvalidStatusChangeException() {
        AidRequest aidRequest = new AidRequest("1", ItemType.ADULT_FEMALE_CLOTHES, 3);
        Assertions.assertThrows(InvalidStatusChangeException.class,
                aidRequest::deliver);
    }

    @Test
    public void whenRequestAllocated_ChangeStatusToDelivered() {
        AidRequest aidRequest = new AidRequest("1", ItemType.ADULT_FEMALE_CLOTHES, 3);
        aidRequest.allocate();
        aidRequest.deliver();
        Assertions.assertEquals(AidRequestStatus.DELIVERED, aidRequest.getStatus());
    }

}
