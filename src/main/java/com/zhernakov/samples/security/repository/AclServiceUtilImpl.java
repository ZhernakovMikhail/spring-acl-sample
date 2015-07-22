package com.zhernakov.samples.security.repository;

import com.zhernakov.samples.security.model.SecuredObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


/**
 * Created by Misha on 22.07.2015.
 */
@Repository("aclServiceUtil")
@Transactional(propagation = Propagation.REQUIRED)
public class AclServiceUtilImpl implements AclServiceUtil {

    @Autowired
    MutableAclService aclService;
    @Autowired
    PlatformTransactionManager transactionManager;

    @Override
    public boolean addPermissionForCurrentUser(final SecuredObject object, Permission permission) {
        TransactionTemplate tt = new TransactionTemplate(transactionManager);

        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                final ObjectIdentity oi = new ObjectIdentityImpl(object.getClass(), object.getId());

                MutableAcl acl = null;
                try {
                    acl = (MutableAcl) aclService.readAclById(oi);
                } catch (NotFoundException e) {
                    acl = aclService.createAcl(oi);
                }

                final PrincipalSid sid = new PrincipalSid(SecurityContextHolder.getContext().getAuthentication());
                acl.insertAce(acl.getEntries().size(), BasePermission.ADMINISTRATION, sid, true);

                aclService.updateAcl(acl);
            }
        });
        return true;
    }

    @Override
    public boolean addPermissionForAuthority(final SecuredObject object, final String authority) {
        TransactionTemplate tt = new TransactionTemplate(transactionManager);

        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                final ObjectIdentity oi = new ObjectIdentityImpl(object.getClass(), object.getId());

                MutableAcl acl = null;
                try {
                    acl = (MutableAcl) aclService.readAclById(oi);
                } catch (NotFoundException e) {
                    acl = aclService.createAcl(oi);
                }

                final GrantedAuthoritySid sid = new GrantedAuthoritySid(authority);
                acl.insertAce(acl.getEntries().size(), BasePermission.ADMINISTRATION, sid, true);

                aclService.updateAcl(acl);
            }
        });
        return true;
    }
}
