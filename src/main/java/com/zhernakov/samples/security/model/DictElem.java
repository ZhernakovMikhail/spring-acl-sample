package com.zhernakov.samples.security.model;

/**
 * Created by Misha on 21.07.2015.
 */
public class DictElem extends AbstractEntity<DictElem> implements SecuredObject {

    public static final DictElem PARENT_ELEM = new DictElem(1L, null);

    Long dictId;
    SecuredObject parent;
    String name;

    public DictElem() {
        parent = PARENT_ELEM;
        dictId = PARENT_ELEM.getId();
    }

    public DictElem(Long id, Long dictId) {
        this.id = id;
        this.dictId = dictId;
        this.parent = PARENT_ELEM;
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
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
