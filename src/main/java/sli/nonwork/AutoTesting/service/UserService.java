package sli.nonwork.AutoTesting.service;

import sli.nonwork.AutoTesting.model.User;

public interface UserService {
    void save(User user);
    
    void update(User user);

    User findByUsername(String username);
}
