package com.zhernakov.samples.security.repository;

import com.zhernakov.samples.security.model.SecuredObject;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Misha on 21.07.2015.
 */
public interface SecuredRepository<T extends SecuredObject> extends Serializable {

    @PostFilter("hasPermission(filterObject, 'READ')")
    Collection<T> getAll(Object... args);

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    T getById(Object... args);

    @PreAuthorize("hasPermission(#object.parent, 'WRITE')")
    T update(@P("object") T object);

    @PreAuthorize("hasPermission(#object.parent, 'CREATE')")
    T add(@P("object") T object);

    @PreAuthorize("hasPermission(#object, 'DELETE')")
    T delete(@P("object") T object);
}
