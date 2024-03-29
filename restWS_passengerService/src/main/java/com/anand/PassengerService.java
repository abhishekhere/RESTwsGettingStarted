package com.anand;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.anand.model.Passenger;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes("application/xml,application/x-www-form-urlencoded")
public interface PassengerService {

	@GET
	@Path("/passengers")
	List<Passenger> getPassengers(@QueryParam("start")int start,@QueryParam("size")int size);

	@POST
	@Path("/passengers")
	void addPassenger(@FormParam("firstName") String firstName,@FormParam("lastName")String lastName,@HeaderParam("agent") String agent);
}
