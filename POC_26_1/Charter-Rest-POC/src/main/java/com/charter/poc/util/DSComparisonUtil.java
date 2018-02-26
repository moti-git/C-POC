package com.charter.poc.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.spectrum.tos.model.device.Device;
import com.spectrum.tos.model.device.Model;


public class DSComparisonUtil {
	
	/*This API will return map which contains different property values to provided objects, if both objects are same
	 * interms their property than it will return empty map
	 * @Param Device d1 
	 * @Param Device d1
	 */
	public static Map<Device, Map<Object, Object>> getDiffirentComparisionVal(Device d1, Device d2) throws IllegalArgumentException, IllegalAccessException {
		
		//To get Device one property
		Map <Object, Object> device1Fields = getFields(d1);
		
		//To get Device one property
		Map <Object, Object> device2Fields = getFields(d2);
		
		//Map to get Device difference property value
		Map <Object, Object> DeviceResult1 = new HashMap<>();
		Map <Object, Object> DeviceResult2 = new HashMap<>();
		
        Map <Device, Map<Object, Object>> deviceComparisonMap =  new HashMap<>();
		      device1Fields.forEach((k,v)->{
		    	  	if(null != v && !device2Fields.get(k).equals(v)){
		    		 DeviceResult1.put(k, v);
		    	     DeviceResult2.put(k,  device2Fields.get(k));
		    	}
		    });
		    deviceComparisonMap.put(d1, DeviceResult1);
		    deviceComparisonMap.put(d2, DeviceResult2);
		return deviceComparisonMap;
		
	}
   
   
	/*
	 * 
	 */
	/* public static Map<Object, Object> getFields(Device d1) throws IllegalArgumentException, IllegalAccessException {
		Class<? extends Device> deviceClass = d1.getClass();
				
		Field [] fields = deviceClass.getDeclaredFields();
		
		//Map to get property details to provided class
		Map<Object,Object> mapFields = new HashMap<>();	   
	    for (Field field : fields) {
	         field.setAccessible(true);

	        try {
	            mapFields.put(field.getName(), field.get(d1));
	            
	        } catch (IllegalAccessException e) {
	        	mapFields.put(field.getName(), field.get(d1));
	        }
	       
	    }

	    return mapFields;
	} */
	
	/* API to get all fields to provided to invoke 
	 * 
	 */
	private static Map<Object, Object> getFields(Device d1) {
	    Class<? extends Device> deviceClass = d1.getClass();
	    Field[] fields = deviceClass.getDeclaredFields();
	    
	    //Map to get property details to provided class
	  	Map<Object,Object> mapFields = new HashMap<>();	   

	    Arrays.stream(fields)
	            .forEach(
	                    field -> {
	                        field.setAccessible(true);
	                        try {
	                        	mapFields.put(field.getName(), field.get(d1));
	                        } catch (final IllegalAccessException e) {
	                        	
									try {
										mapFields.put(field.getName(), field.get(d1));
									} catch (Exception e1) {
										
										e1.printStackTrace();
									}
								
	                        }
	                    });

	    return mapFields;
	}


}
