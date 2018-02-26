package com.charter.poc.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.charter.poc.util.DSComparisonUtil;
import com.spectrum.tos.model.device.Device;



@Service("deviceService")
public class DeviceServiceImpl implements DeviceService{
	
	public Map<Device, Map<Object, Object>> getDeviceComparision(Device device1, Device device2) throws IllegalArgumentException, IllegalAccessException {
		return DSComparisonUtil.getDiffirentComparisionVal(device1, device2);
	}

}
