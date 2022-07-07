package models;

import java.util.Objects;
import java.util.UUID;

/**
 * A model that represents a class subject, such as Mathematics or Software Design
 */
public class Subject implements IUuid{
    private String id;
    private String name;

    public Subject(){
        setId(UUID.randomUUID());
    }
    public Subject(String name){
        setId(UUID.randomUUID());
        setName(name);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(UUID uuid) {
        this.id = uuid.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return getId().equals(subject.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
