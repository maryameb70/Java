package com.example.telepardaz.mappers;

import com.example.telepardaz.dto.MerchantDto;
import com.example.telepardaz.models.Merchant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantMapper extends BaseMapper<MerchantDto, Merchant> {
}
