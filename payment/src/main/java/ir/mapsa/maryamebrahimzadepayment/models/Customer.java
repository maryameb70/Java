package ir.mapsa.maryamebrahimzadepayment.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends AbstractEntity {
    private String firstName;
    private String lastName;
    private Integer age;
    private String cardNumber;
    private String accountNumber;
    private Long balance;
    private String email;
    @Column(unique = true)
    private String customerId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
