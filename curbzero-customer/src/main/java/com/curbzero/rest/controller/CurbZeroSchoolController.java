package com.curbzero.rest.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curbzero.rest.entity.model.Customer;
import com.curbzero.rest.entity.model.Store;
import com.curbzero.rest.entity.model.StoreCustomer;
import com.curbzero.rest.entity.model.repository.StoreCustomerRepository;
import com.curbzero.rest.entity.model.repository.CustomerRepository;
import com.curbzero.rest.entity.model.repository.StoreRepository;
import com.curbzero.rest.model.CurbZeroRequest;
import com.curbzero.rest.model.CurbZeroResponse;

@RestController
@RequestMapping(path = "/track")
public class CurbZeroSchoolController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CurbZeroSchoolController.class);

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private StoreCustomerRepository storeCustomerRepository;

	@PostMapping(value = "/getStatus/V1")
	public ResponseEntity<CurbZeroResponse> getStatus(@RequestBody CurbZeroRequest request) {
		LOGGER.info("getStatus : start");
		long startTime = System.currentTimeMillis();

		CurbZeroResponse response = new CurbZeroResponse();
		Optional<Store> storeOptional = storeRepository.findById(Long.valueOf(request.getStoreId()));
		Optional<Customer> custOptional = customerRepository.findById(Long.parseLong(request.getCustId()));
		StoreCustomer customerStore = storeCustomerRepository.findByStoreOrderId(request.getOrderId());

		ResponseEntity<CurbZeroResponse> responseEntity = null;
		if (!storeOptional.isPresent() || !custOptional.isPresent()) {
			response.setStatus("Failed");
			responseEntity = new ResponseEntity<CurbZeroResponse>(response, HttpStatus.NOT_FOUND);
		} else {
			Store store = storeOptional.get();
			Double currLat = Double.valueOf(request.getClat());
			Double currLong = Double.valueOf(request.getClat());

			Double destLat = new Double(store.getLatitude());
			Double destLong = new Double(store.getLongitude());

			if (customerStore == null) {
				customerStore = new StoreCustomer();
				customerStore.setStoreId(request.getStoreId());
				customerStore.setStoreOrderId(request.getOrderId());
				customerStore.setCustomerId(request.getCustId());
			}
			customerStore.setCustStatus(request.getStatus());
			double disatnce = distance(currLat, destLat, currLong, destLong, "M");
			double dist2 = distance(currLat, destLat, currLong, destLong);
			
			Boolean timeArrived = checkDistanceBetweenDestAndSource(disatnce, currLat, destLat, currLong,
					destLong, store.getTripRange());
			if (timeArrived) {
				customerStore.setCustStatus("2");
			}
			storeCustomerRepository.save(customerStore);

			response.setStatus(customerStore.getCustStatus());
			response.setEstDistance(disatnce + "");
//			response.setCurbResponse("Available");
			response.setNextPing(store.getTripPing());

			responseEntity = new ResponseEntity<CurbZeroResponse>(response, HttpStatus.OK);
		}

		/*
		 * response.setStatus("InProgress");
		 * 
		 * if (checkIfArrived) { response.setStatus("Success"); response.setMessage(
		 * "Parent " + response.getFirstName() + " " + response.getLastName() +
		 * " Ready to pick the child "); }
		 */

		LOGGER.info("getStatus : End " + startTime);
		return responseEntity;
	}

	public static double distance(double lat1, double lat2, double lon1, double lon2) {

		// The math module contains a function
		// named toRadians which converts from
		// degrees to radians.
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		// Haversine formula
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		// Radius of earth in kilometers.
		// Use 3956 for miles
		// Use 6371 for Kilo meters
		double r = 3956;

		// calculate the result
		return (c * r);
	}

	public Boolean checkDistanceBetweenDestAndSource(Double checkDistance, double currLat, double destLat, double currLong, double destLong,
			int timeArrival) {
		// what is this logic?
		/*
		 * { "custId":"1999", "lat_long":"40.588289032,-74.280181885" }
		 */
		int convertToMeter = checkDistance.intValue() * 1000;
		if (convertToMeter < timeArrival) {
			return true;
		}
		return false;
	}

	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		} else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
					+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			// by default it is "M"
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}

}
