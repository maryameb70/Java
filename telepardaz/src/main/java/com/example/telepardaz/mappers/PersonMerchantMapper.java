package com.example.telepardaz.mappers;

import com.example.telepardaz.dto.MerchantDto;
import com.example.telepardaz.dto.PersonMerchantDto;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.PersonMerchant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMerchantMapper extends BaseMapper<PersonMerchantDto, PersonMerchant> {
}
