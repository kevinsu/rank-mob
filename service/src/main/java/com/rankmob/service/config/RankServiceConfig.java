package com.rankmob.service.config;

import com.rankmob.service.user.IUserDAO;
import com.rankmob.service.user.UserDAOMySQLImpl;
import org.springframework.stereotype.Component;

@Component
public class RankServiceConfig {
    public IUserDAO getUserDAO() {
        return new UserDAOMySQLImpl();
    }
}
