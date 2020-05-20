package com.cg.iter.center.service;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.center.entities.DiagnosticCentre;
import com.cg.iter.center.entities.Test;
import com.cg.iter.center.repository.CenterRepository;
/**
 * @author Shirshak
 *
 */
@Service
@Transactional
public class CenterServiceImpl implements CenterService {
   @Autowired
	CenterRepository repo;
	
   private Random rand = new Random();
   private String centreId;
   
	@Override
	public DiagnosticCentre addCentre(DiagnosticCentre diagnosticCentre) {
		
		centreId=Integer.toString(rand.nextInt(1000));
	//	centreId = "CEN"+repo.count(); 
		diagnosticCentre.setCentreId(centreId);
		
		Test test1 = new Test();
		test1.setTestId("bg");
		test1.setTestName("Blood Group");
		Test test2 = new Test();
		test2.setTestId("bs");
		test2.setTestName("Blood Sugar");
		Test test3 = new Test();
		test3.setTestId("bp");
		test3.setTestName("Blood Pressure");
		diagnosticCentre.addTest(test1);
		diagnosticCentre.addTest(test2);
		diagnosticCentre.addTest(test3);
		
		return repo.save(diagnosticCentre);
	}

	@Override
	public String getCentre(String centreName) {
		return repo.getCentre(centreName);

	}

	@Override
	public void deleteCentreById(String centreId) {
		repo.deleteById(centreId);;//JpaRepository method for deleting using centreId
		
	}

	@Override
	public List<DiagnosticCentre> getCentres() {
		return repo.findAll();
	}

	@Override
	public Boolean getDetails(String centreId) {
		return repo.existsById(centreId);
	}

	@Override
	public String getCentreId(String centreId) {
		return repo.getCentreId(centreId);

	}

}
