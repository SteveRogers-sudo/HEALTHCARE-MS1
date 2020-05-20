package com.cg.iter.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.iter.test.entities.DiagnosticCentre;
import com.cg.iter.test.entities.Test;
/**
 * @author Bishal
 *
 */
@Service
public interface TestService {
	Test addTest(Test test);

	List<DiagnosticCentre> getCentres();

	List<Test> getTest();

	DiagnosticCentre findByCentreName(String centreName);

	Optional<Test> findBycentreNameAndTestName(String centreName, String testName);

	void save(DiagnosticCentre centre);

	void deleteTestById(String testId);
	
	

}
