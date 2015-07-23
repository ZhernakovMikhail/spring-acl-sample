package com.zhernakov.samples.security.model;

import java.util.Objects;

/**
 * Created by Misha on 21.07.2015.
 */
public class DictElem extends AbstractEntity<DictElem> implements SecuredObject {

    String name;
    Long dictId;
    SecuredObject parent;

    public DictElem() {
    }

    public DictElem(String name, Long dictId) {
        this.name = name;
        this.dictId = dictId;
    }

    public DictElem(Long id, Long dictId) {
        setId(id);
        setDictId(dictId);
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        if (!Objects.equals(this.dictId, dictId)) {
            if (null != parent && !parent.getId().equals(dictId)) {
                setParent(new Dict(dictId));
            }
        }
        this.dictId = dictId;
    }

    @Override
    public SecuredObject getParent() {
        return parent;
    }

    public void setParent(SecuredObject parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
