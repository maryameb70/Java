package ir.mapsa.telepayer.converters;

import ir.mapsa.telepayer.dto.QRCodeDto;
import ir.mapsa.telepayer.models.QRCode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QRCodeConverter extends BaseConverter<QRCodeDto, QRCode>{
}
