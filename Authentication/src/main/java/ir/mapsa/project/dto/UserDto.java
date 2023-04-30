package ir.mapsa.project.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends AbstractDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private Long cardNumber;
}
