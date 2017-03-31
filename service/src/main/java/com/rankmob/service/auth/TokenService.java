package com.rankmob.service.auth;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class TokenService {
    public String getUsernameFromToken(String token) {
        // Check local cache
        // Check memcached
        return "lalala";
    }

    public String generateAndUseToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        // Cache token to username
        return token;
    }
}
