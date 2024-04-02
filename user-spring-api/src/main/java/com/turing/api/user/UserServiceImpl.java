package com.turing.api.user;

import com.turing.api.enums.Messenger;
import org.hibernate.query.criteria.JpaDerivedFrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
   private final UserRepository re;

    public UserServiceImpl(UserRepository re) {
        this.re = re;
    }

    @Override
    public void save(User newUser) {
        re.save(newUser);
    }

    @Override
    public User findByUsername(String username) {
        return re.findByUsername(username).orElse(null);
    }
}