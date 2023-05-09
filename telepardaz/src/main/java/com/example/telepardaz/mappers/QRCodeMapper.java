package com.example.telepardaz.mappers;


import com.example.telepardaz.dto.QRCodeDto;
import com.example.telepardaz.models.QrRCode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QRCodeMapper extends BaseMapper<QRCodeDto, QrRCode> {
}
