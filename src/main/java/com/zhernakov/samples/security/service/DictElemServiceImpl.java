package com.zhernakov.samples.security.service;

import com.zhernakov.samples.security.model.DictElem;
import com.zhernakov.samples.security.repository.SecuredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Misha on 21.07.2015.
 */
@Service("dictElemService")
public class DictElemServiceImpl implements DictElemService<DictElem> {

    @Autowired
    @Qualifier("dictElemRepository")
    SecuredRepository<DictElem> dictElemRepository;

    @Override
    public Collection<DictElem> getAll(Long dictId) {
        return dictElemRepository.getAll(dictId);
    }

    @Override
    public DictElem getById(long id, long dictId) {
        return dictElemRepository.getById(id, dictId);
    }

    @Override
    public boolean add(DictElem elem) {
        try {
            dictElemRepository.add(elem);
            return true;
        } catch (AccessDeniedException e) {
            return false;
        }
    }

    @Override
    public boolean update(DictElem elem) {
        try {
            dictElemRepository.update(elem);
            return true;
        } catch (AccessDeniedException e) {
            return false;
        }
    }

    @Override
    public boolean delete(DictElem elem) {
        try {
            dictElemRepository.delete(elem);
            return true;
        } catch (AccessDeniedException e) {
            return false;
        }
    }
}
