package ir.mapsa.telepayer.converters;

import ir.mapsa.telepayer.dto.MerchantDto;
import ir.mapsa.telepayer.models.Merchant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantConverter extends BaseConverter<MerchantDto, Merchant>{
}
