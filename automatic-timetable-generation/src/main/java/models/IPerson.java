package models;

import enums.Role;


/**
 * Represents a person that is associated with a school.
 */
public interface IPerson {
    String getId();
    String getName();
    Role getRole();
    void setRole(Role role);
}
