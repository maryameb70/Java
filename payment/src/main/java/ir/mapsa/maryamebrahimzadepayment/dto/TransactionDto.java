package ir.mapsa.maryamebrahimzadepayment.dto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class TransactionDto extends AbstractDto {
    private Long amount;
    private Date date;
    private String source;
    private String destination;
    private String transactionId;
}
