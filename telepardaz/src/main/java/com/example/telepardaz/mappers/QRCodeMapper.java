package com.example.telepardaz.mappers;


import com.example.telepardaz.dto.QRCodeDto;
import com.example.telepardaz.models.QRCode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QRCodeMapper extends BaseMapper<QRCodeDto, QRCode> {
}
