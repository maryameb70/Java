package ir.mapsa.project.converters;

import ir.mapsa.project.dto.UserDto;
import ir.mapsa.project.models.User;

//@Mapper(componentModel = "spring")
public interface AuthenticationConverter extends BaseConverter<UserDto, User>{
}
