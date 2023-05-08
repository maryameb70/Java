package ir.mapsa.telepardaz.mappers;

import ir.mapsa.telepardaz.dto.MerchantDto;
import ir.mapsa.telepardaz.models.Merchant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantMapper extends BaseMapper<MerchantDto, Merchant> {
}
