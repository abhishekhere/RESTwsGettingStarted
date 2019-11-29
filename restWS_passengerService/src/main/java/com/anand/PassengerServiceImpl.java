package com.anand;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.anand.model.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {

	List<Passenger> passengers = new ArrayList<>();
	int currentId = 201;
	
	@Override
	public List<Passenger> getPassengers(int start,int size) {
		System.out.println("start:"+size+", size:"+size);
		return passengers;
	}

	@Override
	public void addPassenger(String firstName,String lastName,String agent) {
		System.out.println("FirstName:"+firstName+", LastName:"+lastName+", Agent:"+agent);
	}

}
