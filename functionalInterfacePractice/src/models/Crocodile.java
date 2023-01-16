package models;

import models.interfaces.Reptile;

import java.util.UUID;

public class Crocodile implements Reptile {
    private final String id;

    public Crocodile(){
        id = UUID.randomUUID().toString();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public ReptileEgg layEgg() {
        return new ReptileEgg(Crocodile::new);
    }

    @Override
    public String toString() {
        return "Crocodile{" +
                "id='" + id + '\'' +
                '}';
    }
}
