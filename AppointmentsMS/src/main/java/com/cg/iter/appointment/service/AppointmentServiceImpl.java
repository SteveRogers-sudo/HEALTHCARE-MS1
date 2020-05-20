package com.cg.iter.appointment.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.appointment.entities.Appointment;
import com.cg.iter.appointment.entities.DiagnosticCentre;
import com.cg.iter.appointment.entities.Test;
import com.cg.iter.appointment.repositories.AppointmentRepository;
import com.cg.iter.appointment.repositories.CentreRepository;
import com.cg.iter.appointment.repositories.TestRepository;
/**
 * @author Abhishek
 *
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	CentreRepository dcrepo;
	@Autowired
	TestRepository trepo;
	@Autowired
	AppointmentRepository arepo;
	
	@Override
	public List<DiagnosticCentre> DiagnosticCenterList() {
		List<DiagnosticCentre> CenterList=dcrepo.findAll();
		return CenterList;
	}

	@Override
	public List<Test> TestsList(String centreId) {
		List<Test> testList=dcrepo.getOne(centreId).getListOfTests();
		return testList;
	}

	@Override
	public String makeAppointment(Appointment app) {
		Appointment updatedApp= arepo.save(app);	
		return "Appointment is Booked";
	}

	@Override
	public Boolean userIdFound(String userId) {
		List<String> exists=arepo.checkUserIdExists(userId);
		Boolean value=exists.isEmpty();
	return value;
	}

	@Override
	public List<Appointment> AppointmentList() {
		List<Appointment> appList=arepo.findAll(); 
		return appList;
	}

	@Override
	public String approveAppointment(Appointment app) {
		arepo.save(app);
		return "Appointment is Approved by admin";
	}


}
