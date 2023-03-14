package ir.mapsa.maryamebrahimzadepayment.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
@Entity
@Table(name="TRANSACTION")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class Transaction extends AbstractEntity {
    private Long amount;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Customer sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Customer receiver;
    @Column(unique = true)
    private String transactionId;
}
