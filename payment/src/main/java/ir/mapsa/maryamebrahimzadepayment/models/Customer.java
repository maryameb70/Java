package ir.mapsa.maryamebrahimzadepayment.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Customer extends AbstractEntity {
    private String firstName;
    private String lastName;
    private Integer age;
    private String cardNumber;
    private Long balance;
    private String email;
    @Column(unique = true)
    private String customerId;
//    it is better not to keep transaction list in customer entity. use unidirectional manyToOne.
    @OneToMany( cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "cardNumber"))
    private List<Transaction> transactions;
}
