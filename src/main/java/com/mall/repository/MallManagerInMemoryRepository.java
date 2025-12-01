package com.mall.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mall.model.MallManager;

@Repository
public class MallManagerInMemoryRepository implements IMallManagerRepository {

    private final Map<Long, MallManager> storage = new HashMap<>();
    private long nextId = 1L;

    @Override
    public MallManager save(MallManager manager) {
        if (manager.getId() == null) {   // MallManager needs getId/setId
            manager.setId(nextId++);
        }
        storage.put(manager.getId(), manager);
        return manager;
    }

    @Override
    public Optional<MallManager> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<MallManager> findAll() {
        return new ArrayList<>(storage.values());
    }
}
