package sli.nonwork.AutoTesting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sli.nonwork.AutoTesting.model.User;
import sli.nonwork.AutoTesting.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public void update(User user) {
		User updateUser = userRepository.findByUsername(user.getUsername());
		
		updateUser.setUsername(user.getUsername());
		updateUser.setPassword(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		
		userRepository.save(updateUser);
	}
}
