package com.zhernakov.samples.security.model;

import java.io.Serializable;

/**
 * Created by Misha on 21.07.2015.
 */
public interface SecuredObject extends Serializable {

    Long getId();

    SecuredObject getParent();
}
