package com.mall.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mall.model.MallAdmin;

@Repository
public class MallAdminInMemoryRepository implements IMallAdminRepository {

    private final Map<Long, MallAdmin> storage = new HashMap<>();
    private long nextId = 1L;

    @Override
    public MallAdmin save(MallAdmin admin) {
        if (admin.getId() == null) {      // make sure MallAdmin has getId/setId
            admin.setId(nextId++);
        }
        storage.put(admin.getId(), admin);
        return admin;
    }

    @Override
    public Optional<MallAdmin> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<MallAdmin> findAll() {
        return new ArrayList<>(storage.values());
    }
}
