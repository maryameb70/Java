package ir.mapsa.telepayer.dto;

import ir.mapsa.telepayer.models.MerchantOrderItem;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;
@Data
@EqualsAndHashCode(callSuper = true)
public class MerchantOrderItemDto extends AbstractDto {
    @NotNull(message = "Entering this field is required")
    private String name ;
    private String category ;
    @NotNull(message = "Entering this field is required")
    @Min(value = 1)
    private Integer quantity ;
    private String productId ;
    @NotNull(message = "Entering this field is required")
    private Integer unitPrice;
}
