package ir.mapsa.project.models;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity{
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private Long cardNumber;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role role = Role.USER;
}
