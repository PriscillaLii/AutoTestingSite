package sli.nonwork.AutoTesting.service;

import sli.nonwork.AutoTesting.model.Testing;

public interface TestingService {
    void save(Testing testing);
    
//    void update(Testing testing);
    
    void delete(Testing testing);
    
    Testing[] findTestingByUserName(String UserName);

}
