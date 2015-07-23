package com.zhernakov.samples.security.service;

import com.zhernakov.samples.security.model.SecuredObject;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Misha on 21.07.2015.
 */
public interface DictService<T extends SecuredObject> extends Serializable {

    Collection<T> getAll();

    T getById(Long id);

    boolean add(T elem);

    boolean update(T elem);

    boolean delete(T elem);
}
