package com.turing.api.user;

import com.turing.api.enums.Messenger;

import java.util.Map;
import java.util.Optional;


public interface UserService {

    void save(User newUser);

    User findByUsername(String username);
}
