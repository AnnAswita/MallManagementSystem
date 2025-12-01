package com.mall.repository;

import java.util.List;
import java.util.Optional;

import com.mall.model.MallManager;

public interface IMallManagerRepository {

    MallManager save(MallManager manager);

    Optional<MallManager> findById(Long id);

    List<MallManager> findAll();
}
