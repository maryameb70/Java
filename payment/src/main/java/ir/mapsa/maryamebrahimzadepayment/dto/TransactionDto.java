package ir.mapsa.maryamebrahimzadepayment.dto;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Data
public class TransactionDto extends AbstractDto {
    private Date date;
    private Long amount;
    private Customer sender;
    private Customer receiver;
    private String transactionId;
}
