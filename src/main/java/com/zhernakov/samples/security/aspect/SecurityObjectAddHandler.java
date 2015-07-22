package com.zhernakov.samples.security.aspect;

import com.zhernakov.samples.security.model.SecuredObject;
import com.zhernakov.samples.security.repository.AclServiceUtil;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.stereotype.Component;

/**
 * Created by Misha on 21.07.2015.
 */
@Component
@Aspect
public class SecurityObjectAddHandler {

    @Autowired
    @Qualifier("aclServiceUtil")
    AclServiceUtil aclServiceUtil;

    @Pointcut("execution(* com.zhernakov.samples.security.repository.SecuredRepository.add(com.zhernakov.samples.security.model.SecuredObject))")
    public void addPoint() {
    }

    @AfterReturning(pointcut = "addPoint()", returning = "result")
    public void addAdminPermissionForCurrentUser(final SecuredObject result) {
        aclServiceUtil.addPermissionForCurrentUser(result, BasePermission.ADMINISTRATION);
    }
}
