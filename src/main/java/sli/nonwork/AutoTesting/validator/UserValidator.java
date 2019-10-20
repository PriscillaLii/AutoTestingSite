package sli.nonwork.AutoTesting.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sli.nonwork.AutoTesting.model.User;
import sli.nonwork.AutoTesting.repository.UserRepository;
import sli.nonwork.AutoTesting.service.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 1 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 1 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
    
    public void validateChange(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 1 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) == null) {
            errors.rejectValue("username", "No.such.user.to.change");
        }
        
        
        if (user.getPassword().length() < 1 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Password.Incorrect");
        }
        
        // 这儿没写出来！！！！！！！！！
        /*User updateUser = userRepository.findByUsername(user.getUsername());
        if(!bCryptPasswordEncoder.encode(user.getPassword()).equals(updateUser.getPassword())) {
        		errors.rejectValue("password", "Password.Incorrect");
        }*/
        
        
        if (user.getPasswordConfirm().length() < 1 || user.getPasswordConfirm().length() > 32) {
            errors.rejectValue("passwordConfirm", "Size.userForm.password");
        }

        if (user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.newPassword");
        }
    }
}
