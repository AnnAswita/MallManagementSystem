/**
 * author : carolin.thomas
 */
package com.mall.repository;

import com.mall.model.Address;
import tools.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AddressRepository {


    private static final String FILE_PATH = "src/main/resources/data/addresses.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Address> loadAddresses() {
        try {
            File file = new File(FILE_PATH);

            if (!file.exists()) return new ArrayList<>();

            return Arrays.asList(mapper.readValue(file, Address[].class));

        } catch (Exception e) {
            throw new RuntimeException("Error reading addresses.json", e);
        }
    }

    public void saveAddresses(List<Address> addresses) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(new File(FILE_PATH), addresses);
        } catch (Exception e) {
            throw new RuntimeException("Error writing addresses.json", e);
        }
    }
}
