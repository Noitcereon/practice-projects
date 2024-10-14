package models;

import models.interfaces.Reptile;

import java.util.UUID;

public class FireDragon implements Reptile {

    private final String id;
    public FireDragon(){
        id = UUID.randomUUID().toString();
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public ReptileEgg layEgg() {
        return new ReptileEgg(FireDragon::new);
    }

    @Override
    public String toString() {
        return "FireDragon{" +
                "id='" + id + '\'' +
                '}';
    }
}
