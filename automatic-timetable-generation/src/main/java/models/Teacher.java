package models;

import enums.Role;

import java.util.HashSet;
import java.util.Set;

public class Teacher extends Person {
    private final Set<String> subjects = new HashSet<>();

    public Teacher(String name, Role role) {
        super(name, role);
    }

    public Set<String> getSubjects() {
        return subjects;
    }

    public void addSubject(String subject) {
        this.subjects.add(subject);
    }
    public void removeSubject(String subject){
        this.subjects.remove(subject);
    }

    @Override
    public String toString() {
        return getName();
    }
}
