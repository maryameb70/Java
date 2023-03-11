package ir.mapsa.maryamebrahimzadepayment.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerDto extends AbstractDto{
    private String firstName;
    private String lastName;
    private Integer age;
    private String cardNumber;
    private String accountNumber;
    private Long balance;
    private String email;
    private String customerId;
}
