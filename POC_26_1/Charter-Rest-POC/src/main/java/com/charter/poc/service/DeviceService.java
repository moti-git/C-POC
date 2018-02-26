package com.charter.poc.service;


import java.util.Map;

import com.spectrum.tos.model.device.Device;

public interface DeviceService {
	
	public Map<Device, Map<Object, Object>> getDeviceComparision(Device device1, Device device2) 
			throws IllegalArgumentException, IllegalAccessException;
	
}
