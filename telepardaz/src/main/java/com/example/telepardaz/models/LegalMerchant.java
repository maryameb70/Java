package com.example.telepardaz.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("LEGAL")
public class LegalMerchant extends Merchant {
    private String storeName;
    private String postalCode;
    private String description;
    private String address;
}
