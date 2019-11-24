package com.anand;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.anand.model.Patient;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/patientservice")
public interface PatientService {
	
	@Path("/patients")
	@GET
	public List<Patient> getPatients();
	
	@Path("/patients/{identifier}")
	@GET
	public Patient getPatient(@PathParam("identifier") long id);
	
	@Path("/patients")
	@POST
	Response createPatient(Patient patient);
	
	@Path("/patients")
	@PUT
	Response updatePatient(Patient patient);
	
	@Path("/patients/{identifier}")
	@DELETE
	Response deletePatient(@PathParam("identifier")long id);

}
