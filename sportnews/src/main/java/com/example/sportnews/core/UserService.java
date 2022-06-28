package com.example.sportnews.core;

import com.example.sportnews.repositories.UserRepository;
import com.example.sportnews.core.models.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {
    private final UserRepository repository;


    private static final String paper="";
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public String authorizeUser(String username, String password) {
        User user;
        try {
            user = Mappers.fromUsersDAO(repository.getUserByUsername(username));
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("");
        }
        String hash = sha256(user.salt + password + paper);
        if (!hash.equals(user.password))
            throw new InvalidParameterException();

        return hash;
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }
    public User createUser(String username, String password, String email){

        String salt = generateSalt();

        String passwordHash = sha256(salt + password + paper);

        return Mappers.fromUsersDAO(
                repository.createUser(username,passwordHash,email,salt));
    }
    private static String sha256(String originalString) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
    public User getUser(int id) {
        return Mappers.fromUsersDAO(repository.getUser(id));
    }
    public User getUserByUsername(String username){
        return Mappers.fromUsersDAO(repository.getUserByUsername(username));
    }

    public void deleteUser(int id) {
        repository.deleteUser(id);
    }

    public List<User> listUsers(int page, int pageSize) {
        return repository.listUsers(page, pageSize)
                .stream()
                .map(Mappers::fromUsersDAO)
                .collect(Collectors.toList());
    }
}
