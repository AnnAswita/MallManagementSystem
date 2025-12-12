/**
 * author: carolin.thomas
 */
package com.mall.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mall.model.Item;

import tools.jackson.databind.ObjectMapper;

@Repository
public class ItemRepository {
	
	private static final String FILE_PATH = "src/main/resources/data/items.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Item> loadItems() {
        try {
            File file = new File(FILE_PATH);

            if (!file.exists()) return new ArrayList<>();

            return Arrays.asList(mapper.readValue(file, Item[].class));

        } catch (Exception e) {
            throw new RuntimeException("Error reading items.json", e);
        }
    }

    public void saveItems(List<Item> items) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(new File(FILE_PATH), items);
        } catch (Exception e) {
            throw new RuntimeException("Error writing items.json", e);
        }
    }

}
