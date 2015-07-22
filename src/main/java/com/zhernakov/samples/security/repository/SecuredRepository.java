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

    @PostFilter("hasAuthority('ADMIN') or hasPermission(filterObject, 'READ') or hasPermission(filterObject, 'WRITE') or hasPermission(filterObject, 'ADMINISTRATION')")
    Collection<T> getAll(Object... args);

    @PostAuthorize("hasAuthority('ADMIN') or hasPermission(returnObject, 'READ') or hasPermission(returnObject, 'WRITE') or hasPermission(returnObject, 'ADMINISTRATION')")
    T getById(Object... args);

    @PreAuthorize("hasAuthority('ADMIN') or hasPermission(#object.parent, 'WRITE') or hasPermission(#object.parent, 'ADMINISTRATION')")
    T update(@P("object") T object);

    @PreAuthorize("hasAuthority('ADMIN') or hasPermission(#object.parent, 'CREATE') or hasPermission(#object.parent, 'ADMINISTRATION')")
    T add(@P("object") T object);

    @PreAuthorize("hasAuthority('ADMIN') or hasPermission(#object, 'DELETE') or hasPermission(#object.parent, 'ADMINISTRATION')")
    T delete(@P("object") T object);
}
