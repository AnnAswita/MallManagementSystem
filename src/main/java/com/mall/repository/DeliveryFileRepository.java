/**
 * author : carolin.thomas
 */
package com.mall.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mall.model.Delivery;

import tools.jackson.databind.ObjectMapper;

/**
 * 
 */
public class DeliveryFileRepository {
	
    private static final String FILE_PATH = "src/main/resources/data/deliveryStaff.json";
    private final ObjectMapper mapper = new ObjectMapper();

	/*
	 * public List<DeliveryStaff> loadDeliveryStaff() { try { File file = new
	 * File(FILE_PATH);
	 * 
	 * if (!file.exists()) return new ArrayList<>();
	 * 
	 * // return Arrays.asList(mapper.readValue(file, DeliveryStaff[].class));
	 * 
	 * } catch (Exception e) { throw new
	 * RuntimeException("Error reading deliveryStaff.json", e); } }
	 * 
	 * public void saveDeliveryStaff(List<DeliveryStaff> staffList) { try {
	 * mapper.writerWithDefaultPrettyPrinter() .writeValue(new File(FILE_PATH),
	 * staffList); } catch (Exception e) { throw new
	 * RuntimeException("Error writing deliveryStaff.json", e); } }
	 */

}
