package com.zhernakov.samples.security.aspect;

import com.zhernakov.samples.security.model.SecuredObject;
import com.zhernakov.samples.security.repository.AclServiceUtil;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Misha on 21.07.2015.
 */
@Component
@Aspect
@Order(1)
public class SecurityObjectAddForAdminHandler {

    @Autowired
    @Qualifier("aclServiceUtil")
    AclServiceUtil aclServiceUtil;

    @Pointcut("execution(* com.zhernakov.samples.security.repository.SecuredRepository.add(com.zhernakov.samples.security.model.SecuredObject))")
    public void addPoint() {
    }

    @AfterReturning(pointcut = "addPoint()", returning = "result")
    public void addAdminPermissionForCurrentUser(final SecuredObject result) {
        aclServiceUtil.addPermissionForAuthority(result, "ADMIN");
    }
}
