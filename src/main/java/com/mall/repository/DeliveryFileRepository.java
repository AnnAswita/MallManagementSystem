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
	
	private static final String FILE_PATH = "src/main/resources/data/deliveries.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Delivery> load() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new ArrayList<>();
            return Arrays.asList(mapper.readValue(file, Delivery[].class));
        } catch (Exception e) {
            throw new RuntimeException("Error reading deliveries.json", e);
        }
    }

    public void save(List<Delivery> deliveries) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), deliveries);
        } catch (Exception e) {
            throw new RuntimeException("Error writing deliveries.json", e);
        }
    }
}
