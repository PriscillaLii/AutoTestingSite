package sli.nonwork.AutoTesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sli.nonwork.AutoTesting.model.Testing;

public interface TestingRepository extends JpaRepository<Testing, Long> {
	
	Testing[] findTestingByUserName(String UserName);
	
}
