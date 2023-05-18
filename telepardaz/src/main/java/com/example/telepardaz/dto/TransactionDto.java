package com.example.telepardaz.dto;

import com.example.telepardaz.enums.TrackingStatus;
import lombok.*;
@Data
@EqualsAndHashCode(callSuper = true)
public class TransactionDto extends BaseDto {
    private String trackingId;
    private TrackingStatus status;
    private Long amount;
    private String userName;
}
