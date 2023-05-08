package ir.mapsa.project.controllers;

import ir.mapsa.project.dto.UserDto;
import ir.mapsa.project.exceptions.ServiceException;
import ir.mapsa.project.models.User;
import ir.mapsa.project.services.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController extends AbstractController<User, UserDto, AuthenticationService> {
    @PostMapping("/register")
    public void add(@RequestBody UserDto dto) throws ServiceException, NoSuchAlgorithmException, InvalidKeySpecException {
        service.register(dto);
    }
}
