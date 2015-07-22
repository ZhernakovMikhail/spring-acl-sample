package com.zhernakov.samples.security.model;

import java.io.Serializable;

/**
 * Created by Misha on 21.07.2015.
 */
public abstract class AbstractEntity<T extends AbstractEntity> {

    Serializable id;

    public Serializable getId() {
        return id;
    }

    public T setId(Serializable id) {
        this.id = id;
        return (T) this;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }

        AbstractEntity that = (AbstractEntity) obj;

        return this.id.equals(that.getId());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
