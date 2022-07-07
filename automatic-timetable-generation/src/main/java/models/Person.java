package models;

import enums.Role;

public class Person implements IPerson {
    private String id;
    private final String name;
    private Role role;

    public Person(String name, Role role){
        this.name = name;
        this.role = role;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Role getRole() {
        return role;
    }
    @Override
    public void setRole(Role role){
        this.role = role;
    }
}
