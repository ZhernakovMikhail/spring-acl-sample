package com.zhernakov.samples.security.repository;

import com.zhernakov.samples.security.model.SecuredObject;
import org.springframework.security.acls.model.Permission;


/**
 * Created by Misha on 22.07.2015.
 */
public interface AclServiceUtil {
    boolean addPermissionForCurrentUser(final SecuredObject object, final Permission permission);

    boolean addPermissionForAuthority(final SecuredObject object, final String authority);
}
