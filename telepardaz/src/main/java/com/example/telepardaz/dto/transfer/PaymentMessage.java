package com.example.telepardaz.dto.transfer;

import com.example.telepardaz.enums.TrackingStatus;
import lombok.Data;

@Data
public class PaymentMessage {
//    private String message;
    private TrackingStatus trackingStatus;
}
