package com.mall.repository;

import com.mall.entity.Shop;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopJsonRepository {

    private final String filePath = "src/main/resources/data/shops.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Shop> loadShops() {
        try {
            File file = new File(filePath);
            if (!file.exists()) return new ArrayList<>();

            return mapper.readValue(file, new TypeReference<List<Shop>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveShops(List<Shop> shops) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), shops);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Shop save(Shop shop) {
        List<Shop> shops = loadShops();

        if (shop.getShopID() == null) {
            shop.setShopID(generateId(shops));
        }

        shops.removeIf(s -> s.getShopID().equals(shop.getShopID()));
        shops.add(shop);

        saveShops(shops);
        return shop;
    }

    public Optional<Shop> findById(Long id) {
        return loadShops().stream().filter(s -> s.getShopID().equals(id)).findFirst();
    }

    public List<Shop> findAll() {
        return loadShops();
    }

    public void delete(Long id) {
        List<Shop> shops = loadShops();
        shops.removeIf(s -> s.getShopID().equals(id));
        saveShops(shops);
    }

    private Long generateId(List<Shop> shops) {
        return shops.stream().mapToLong(Shop::getShopID).max().orElse(0) + 1;
    }
}
