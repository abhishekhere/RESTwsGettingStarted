package com.anand;

import javax.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;

import com.anand.model.ChecksList;

@Service
public class CheckProcessorImpl implements CheckProcessor {

	@Override
	public void processChecks(AsyncResponse response, ChecksList checksList) {
		// To make it multithreaded
		new Thread() {
			public void run() {
				response.resume(true);
			}
		}.start();
	}

}
