package com.example.telepardaz.models;

import com.example.telepardaz.enums.TrackingStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transaction")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends BaseEntity{
    private String trackingId;
    private TrackingStatus status;
    private Long amount;
    private String userName;
}
