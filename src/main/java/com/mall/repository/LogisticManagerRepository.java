/**
 * authore: carolin.thomas
 */
package com.mall.repository;


import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public class LogisticManagerRepository {
	
	private static final String FILE_PATH = "src/main/resources/data/logisticManager.json";
    private final ObjectMapper mapper = new ObjectMapper();

	/*
	 * public List<LogisticManager> loadManagers() { try { File file = new
	 * File(FILE_PATH);
	 * 
	 * if (!file.exists()) return new ArrayList<>();
	 * 
	 * return Arrays.asList(mapper.readValue(file, LogisticManager[].class));
	 * 
	 * } catch (Exception e) { throw new
	 * RuntimeException("Error reading logisticManager.json", e); } }
	 * 
	 * public void saveManagers(List<LogisticManager> managers) { try {
	 * mapper.writerWithDefaultPrettyPrinter() .writeValue(new File(FILE_PATH),
	 * managers); } catch (Exception e) { throw new
	 * RuntimeException("Error writing logisticManager.json", e); } }
	 */

}
