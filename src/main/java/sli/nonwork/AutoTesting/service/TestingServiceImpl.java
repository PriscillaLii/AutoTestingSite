package sli.nonwork.AutoTesting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sli.nonwork.AutoTesting.model.Testing;
import sli.nonwork.AutoTesting.model.User;
import sli.nonwork.AutoTesting.repository.TestingRepository;
import sli.nonwork.AutoTesting.repository.UserRepository;


@Service
public class TestingServiceImpl implements TestingService {
    @Autowired
    private TestingRepository testingRepository;

    @Override
    public void save(Testing testing) {
    		testingRepository.save(testing);
    }

//	@Override
//	public Testing findById(Long id) {
//		
//		return testingRepository.findByTestingId(id);
//	}
//
//	@Override
//	public void update(Testing testing) {
//		// TODO Auto-generated method stub
//		
//	}
	
	@Override
	public void delete(Testing testing) {
		testingRepository.delete(testing);
	}

	@Override
	public Testing[] findTestingByUserName(String UserName) {
		return testingRepository.findTestingByUserName(UserName);
		
	}
}
