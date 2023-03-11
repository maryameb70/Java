package ir.mapsa.maryamebrahimzadepayment.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TransferDto extends AbstractDto {
    private String source;
    private String destination;
    private Long amount;
    private String transferId;
}
