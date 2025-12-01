package com.mall.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mall.model.DeliveryStaff;

import tools.jackson.databind.ObjectMapper;

public class DeliveryStaffRepository {

    private static final String FILE_PATH = "src/main/resources/data/deliveryStaff.json";

    private final ObjectMapper mapper = new ObjectMapper();

    // Load all delivery staff
    public List<DeliveryStaff> loadDeliveryStaff() {
        try {
            File file = new File(FILE_PATH);

            if (!file.exists()) {
                return new ArrayList<>();
            }

            return Arrays.asList(mapper.readValue(file, DeliveryStaff[].class));

        } catch (Exception e) {
            throw new RuntimeException("Error reading deliveryStaff.json", e);
        }
    }

    // Save all delivery staff
    public void saveDeliveryStaff(List<DeliveryStaff> staffList) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(FILE_PATH), staffList);

        } catch (Exception e) {
            throw new RuntimeException("Error writing deliveryStaff.json", e);
        }
    }
}
