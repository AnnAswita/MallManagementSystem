/**
 * author : carolin.thomas
 */
package com.mall.repository;


import com.mall.model.Supplier;
import tools.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SupplierRepository {
	
	    private static final String FILE_PATH = "src/main/resources/data/suppliers.json";
	    private final ObjectMapper mapper = new ObjectMapper();

	    public List<Supplier> loadSuppliers() {
	        try {
	            File file = new File(FILE_PATH);

	            if (!file.exists()) return new ArrayList<>();

	            return Arrays.asList(mapper.readValue(file, Supplier[].class));

	        } catch (Exception e) {
	            throw new RuntimeException("Error reading suppliers.json", e);
	        }
	    }

	    public void saveSuppliers(List<Supplier> suppliers) {
	        try {
	            mapper.writerWithDefaultPrettyPrinter()
	                  .writeValue(new File(FILE_PATH), suppliers);
	        } catch (Exception e) {
	            throw new RuntimeException("Error writing suppliers.json", e);
	        }
	    }
	
}
