package com.anand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.anand.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	Map<Long, Patient> patients = new HashMap<>();
	private long currentId = 121;

	public PatientServiceImpl() {
		init();
	}

	private void init() {
		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("Abhishek");
		
		patients.put(patient.getId(),patient);
		
	}

	@Override
	public List<Patient> getPatients() {
		Collection<Patient> result = patients.values();
		ArrayList<Patient> response = new ArrayList<>(result);
		return response;
	}

	@Override
	public Patient getPatient(long id) {
		return patients.get(id);
	}

	@Override
	public Response createPatient(Patient patient) {
		currentId++;
		patient.setId(currentId);
		patients.put(currentId, patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(Patient patient) {
		Patient current_patient = patients.get(patient.getId());
		Response response;
		if(current_patient!=null) {
			patients.put(patient.getId(), patient);
			response=Response.ok().build();
		}
		else {
			response=Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deletePatient(long id) {
		Response response;
		if(patients.containsKey(id)) {
			patients.remove(id);
			response = Response.ok().build();
		}else {
			response = Response.notModified().build();
		}
		return response;
	}

	
}
