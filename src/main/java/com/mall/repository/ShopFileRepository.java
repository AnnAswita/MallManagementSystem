package com.mall.repository.impl;

import com.mall.model.Shop;
import com.mall.repository.IShopRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ShopFileRepository implements IShopRepository {

    private static final String FILE_PATH = "src/main/resources/data/shops.json";
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Shop> loadShops() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new ArrayList<>();
            return Arrays.asList(mapper.readValue(file, Shop[].class));
        } catch (Exception e) {
            throw new RuntimeException("Error reading shops.json", e);
        }
    }

    @Override
    public void saveShops(List<Shop> shops) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), shops);
        } catch (Exception e) {
            throw new RuntimeException("Error writing shops.json", e);
        }
    }
