package ir.mapsa.telepayer.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="merchants")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Merchant extends AbstractEntity{
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String accountNumber;
    @Column
    private String cardNumber;
    @Column(unique = true)
    private String merchantId;
}
