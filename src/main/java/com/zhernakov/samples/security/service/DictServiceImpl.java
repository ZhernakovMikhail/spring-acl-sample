package com.zhernakov.samples.security.service;

import com.zhernakov.samples.security.model.Dict;
import com.zhernakov.samples.security.repository.SecuredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Misha on 21.07.2015.
 */
@Service("dictService")
public class DictServiceImpl implements DictService<Dict> {

    @Autowired
    @Qualifier("dictRepository")
    SecuredRepository<Dict> dictRepository;

    @Override
    public Collection<Dict> getAll() {
        return dictRepository.getAll();
    }

    @Override
    public Dict getById(Long id) {
        return dictRepository.getById(id);
    }

    @Override
    public boolean add(Dict elem) {
        try {
            dictRepository.add(elem);
            return true;
        } catch (AccessDeniedException e) {
            return false;
        }
    }

    @Override
    public boolean update(Dict elem) {
        try {
            dictRepository.update(elem);
            return true;
        } catch (AccessDeniedException e) {
            return false;
        }
    }

    @Override
    public boolean delete(Dict elem) {
        try {
            dictRepository.delete(elem);
            return true;
        } catch (AccessDeniedException e) {
            return false;
        }
    }
}
