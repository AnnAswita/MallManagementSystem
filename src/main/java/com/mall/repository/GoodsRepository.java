/**
 * author:carolin.thomas
 */
package com.mall.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mall.model.Goods;

import tools.jackson.databind.ObjectMapper;

/**
 * 
 */
public class GoodsRepository {
	
	 private static final String FILE_PATH = "src/main/resources/data/goods.json";
	    private final ObjectMapper mapper = new ObjectMapper();

	    public List<Goods> loadGoods() {
	        try {
	            File file = new File(FILE_PATH);

	            if (!file.exists()) return new ArrayList<>();

	            return Arrays.asList(mapper.readValue(file, Goods[].class));

	        } catch (Exception e) {
	            throw new RuntimeException("Error reading goods.json", e);
	        }
	    }

	    public void saveGoods(List<Goods> goodsList) {
	        try {
	            mapper.writerWithDefaultPrettyPrinter()
	                  .writeValue(new File(FILE_PATH), goodsList);
	        } catch (Exception e) {
	            throw new RuntimeException("Error writing goods.json", e);
	        }
	    }

}
