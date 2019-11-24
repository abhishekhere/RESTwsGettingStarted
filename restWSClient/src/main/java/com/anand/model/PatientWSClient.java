package com.anand.model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PatientWSClient {

	private static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice";

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		//---Getting the records
		WebTarget target = client.target(PATIENT_SERVICE_URL).path("/patients").path("/{id}").resolveTemplate("id", 121);
		Builder request = target.request();
		//Response response = request.get();
		//System.out.println(response.getStatus());
		Patient patient = request.get(Patient.class);
		System.out.println(patient.getName()+","+patient.getId());
		
		//---Updating the records
		patient.setName("Julie");
		WebTarget put_target = client.target(PATIENT_SERVICE_URL).path("/patients");
		Response response = put_target.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
		System.out.println(response.getStatus());
		response.close();
		
		//---Creating a new record
		Patient newPatient = new Patient();
		newPatient.setName("Bobss");
		WebTarget post_target = client.target(PATIENT_SERVICE_URL).path("/patients");
		Patient created_patient = post_target.request().post(Entity.entity(patient, MediaType.APPLICATION_XML),Patient.class);
		System.out.println("Created patient id: "+created_patient.getId());
		
		client.close();
		
	}

}
