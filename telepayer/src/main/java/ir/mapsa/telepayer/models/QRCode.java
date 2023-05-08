package ir.mapsa.telepayer.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.util.List;
@Entity
@Table(name = "QRCode")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QRCode extends AbstractEntity{
    @Column(name = "merchantPaymentId")
    private String merchantPaymentId;

    @Column(name ="amount")
    private Integer amount ;

    @Column(name ="orderDescription")
    private String orderDescription;

    @Column(name ="orderItems")
    @OneToMany
    private List<MerchantOrderItem> orderItems ;

    @Column(name ="metadata")
    private Object metadata ;

    @Column(name ="codeType")
    private String codeType;

    @Column(name ="storeInfo")
    private String storeInfo ;

    @Column(name ="storeId")
    private String storeId ;

    @Column(name ="terminalId")
    private String terminalId ;

    @Column(name ="requestedAt")
    private Long requestedAt = Instant.now().getEpochSecond();

    @Column(name ="isAuthorization")
    private Boolean isAuthorization ;

    @Column(name ="authorizationExpiry")
    private Long authorizationExpiry ;

    @Column(name ="redirectUrl")
    private String redirectUrl ;

 }
