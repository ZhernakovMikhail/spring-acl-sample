INSERT INTO users (username, password, enabled) VALUES ('admin', 'q', 1);
INSERT INTO users (username, password, enabled) VALUES ('user', 'q', 1);

INSERT INTO authorities (username, authority) VALUES ('admin', 'ADMIN');
INSERT INTO authorities (username, authority) VALUES ('user', 'USER');

INSERT INTO acl_sid (principal, sid) SELECT
                                       1,
                                       username
                                     FROM users;
INSERT INTO acl_sid (principal, sid) SELECT DISTINCT
                                       0,
                                       authority
                                     FROM authorities;

INSERT INTO acl_class (class) VALUES ('com.zhernakov.samples.security.model.DictElem');

INSERT INTO acl_object_identity (object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting)
VALUES (100, 1, NULL, 100, 1);

INSERT INTO acl_entry (acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure)
VALUES (100, 100, 101, 4, 1, 1, 1);