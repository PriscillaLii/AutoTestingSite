package sli.nonwork.AutoTesting.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
