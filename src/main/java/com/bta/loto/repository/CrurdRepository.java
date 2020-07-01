package com.bta.loto.repository;

import com.bta.loto.model.BaseEntity;

import java.util.List;

public interface CrurdRepository<E extends BaseEntity> {
    int save(E entity);

    int update(E entity);

    List<E> findAll();


}
