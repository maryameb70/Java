package ir.mapsa.telepardaz.mappers;

import ir.mapsa.telepardaz.dto.QRCodeDto;
import ir.mapsa.telepardaz.models.QRCode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QRCodeMapper extends BaseMapper<QRCodeDto, QRCode> {
}
