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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MerchantOrderItem merchantOrderItem = (MerchantOrderItem) o;
        return Objects.equals(this.name, merchantOrderItem.getName()) &&
                Objects.equals(this.category, merchantOrderItem.getCategory()) &&
                Objects.equals(this.quantity, merchantOrderItem.getQuantity()) &&
                Objects.equals(this.productId, merchantOrderItem.getProductId()) &&
                Objects.equals(this.unitPrice, merchantOrderItem.getUnitPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, quantity, productId, unitPrice);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MerchantOrderItem {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
        sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
