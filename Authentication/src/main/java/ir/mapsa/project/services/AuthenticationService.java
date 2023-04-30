package ir.mapsa.project.services;

import ir.mapsa.project.dto.UserDto;
import ir.mapsa.project.exceptions.ServiceException;
import ir.mapsa.project.models.User;
import ir.mapsa.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AuthenticationService extends AbstractService<UserRepository, User> {
    @Autowired
    private UserRepository repository;

    public void register(UserDto dto) throws NoSuchAlgorithmException, InvalidKeySpecException, ServiceException {
        User existingUsers = repository.findByUsername(dto.getUsername());
        if (existingUsers != null) {
            throw new ServiceException("This_user_exists_in_the_system");
        }
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(encryptPass(dto.getPassword()));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAccountNumber(dto.getAccountNumber());
        user.setCardNumber(dto.getCardNumber());
        repository.save(user);
    }

    private String encryptPass(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 512);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        return enc.encodeToString(hash);
    }
}
