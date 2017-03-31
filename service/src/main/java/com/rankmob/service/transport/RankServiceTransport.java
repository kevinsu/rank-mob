package com.rankmob.service.transport;

import com.rankmob.service.api.LoginContext;
import com.rankmob.service.api.RegisterContext;
import com.rankmob.service.auth.AuthService;
import com.rankmob.service.config.RankServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankServiceTransport {
    private AuthService authService;

    @Autowired
    public RankServiceTransport(RankServiceConfig config, AuthService authService) {
        this.authService = authService;
    }

    public String login(LoginContext loginContext) {
        return authService.login(
                loginContext.getUsername(),
                loginContext.getPassword());
    }

    public String register(RegisterContext registerContext) {
        return authService.register(
                registerContext.getUsername(),
                registerContext.getPassword(),
                registerContext.getEmail());
    }
}
