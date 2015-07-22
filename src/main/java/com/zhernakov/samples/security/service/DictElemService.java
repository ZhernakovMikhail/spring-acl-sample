package com.zhernakov.samples.security.service;

import java.util.Collection;

/**
 * Created by Misha on 21.07.2015.
 */
public interface DictElemService<T> {

    Collection<T> getAll(Long dictId);

    T getById(long id, long dictId);

    boolean add(T elem);

    boolean update(T elem);

    boolean delete(T elem);
}
