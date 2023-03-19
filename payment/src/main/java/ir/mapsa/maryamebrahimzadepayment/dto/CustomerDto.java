package ir.mapsa.maryamebrahimzadepayment.dto;

import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerDto extends AbstractDto{
    private String firstName;
    private String lastName;
    private Integer age;
    private String cardNumber;
    private Long balance;
    private String email;
    private String customerId;
}
