package com.mall.repository;

import java.util.List;
import java.util.Optional;

import com.mall.model.MallAdmin;

public interface IMallAdminRepository {

    MallAdmin save(MallAdmin admin);

    Optional<MallAdmin> findById(Long id);

    List<MallAdmin> findAll();
}
