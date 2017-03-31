package com.rankmob.service.auth;

import com.rankmob.service.config.RankServiceConfig;
import com.rankmob.service.exception.NotAuthorizedException;
import com.rankmob.service.exception.UserExistsException;
import com.rankmob.service.user.IUserDAO;
import com.rankmob.service.user.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService {
    private IUserDAO userDAO;
    private TokenService tokenService;

    @Autowired
    public AuthService(RankServiceConfig config, TokenService tokenService) {
        this.tokenService = tokenService;
        userDAO = config.getUserDAO();
    }

    public String login(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            throw new NotAuthorizedException();
        }
        String hashedPassword = getHashedPassword(password);
        if (!hashedPassword.equals(user.getHashedPassword())) {
            throw new NotAuthorizedException();
        }
        return tokenService.generateAndUseToken();
    }

    public String register(String username, String password, String email) {
        String hashedPassword = getHashedPassword(password);
        userDAO.createUser(username, hashedPassword, email);
        return tokenService.generateAndUseToken();
    }

    public String getHashedPassword(String password) {
        return DigestUtils.md2Hex(password);
    }

    public boolean isAuthenticated(String token) {
        String username = tokenService.getUsernameFromToken(token);
        return username != null;
    }
}
