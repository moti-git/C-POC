package com.charter.poc.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charter.poc.service.DeviceService;
import com.spectrum.tos.model.device.Device;


@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	 
	@Autowired
	DeviceService deviceService;//Service which will do all data retrieval/manipulation work

	
	@RequestMapping(value="/deviceComparison/", method = RequestMethod.GET)
	public Map<Device, Map<Object, Object>> getDeviceComparision(Device device1, Device device2) {
		logger.info("Fetching Difference");
		
		try {
			return deviceService.getDeviceComparision(device1, device2);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}