package com.bta.loto.repository;

import com.bta.loto.model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractRepository<E extends BaseEntity> implements CrurdRepository<E> {

    @Autowired
    protected NamedParameterJdbcTemplate nameParameterJdbcTemplate;

    @Autowired
    protected JdbcTemplate jdbcTemplate;



}
