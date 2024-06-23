package com.springcamp.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service <T>{

    T save(T t);
    T getById(Integer id);
    List<T> getAll();
    Page<T> getAll(Pageable pageable);
    void delete(Integer id);
}
