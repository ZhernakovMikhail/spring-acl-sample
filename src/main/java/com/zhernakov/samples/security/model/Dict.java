package com.zhernakov.samples.security.model;

/**
 * Created by Misha on 21.07.2015.
 */
public class Dict extends AbstractEntity<Dict> implements SecuredObject {

    SecuredObject parent;
    String name;

    public Dict() {
    }

    public Dict(String name) {
        this.name = name;
    }

    public Dict(Long id) {
        this.id = id;
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
