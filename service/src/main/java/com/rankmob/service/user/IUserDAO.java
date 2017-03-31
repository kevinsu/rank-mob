package com.rankmob.service.user;

import com.rankmob.service.exception.UserExistsException;

public interface IUserDAO {
    public User getUserByUsername(String username);
    public User createUser(String username,
                           String hashedPassword,
                           String email) throws UserExistsException;
}
