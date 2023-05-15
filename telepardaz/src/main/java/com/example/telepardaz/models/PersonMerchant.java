package com.example.telepardaz.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@DiscriminatorValue("PERSON")
public class PersonMerchant extends Merchant {


}
