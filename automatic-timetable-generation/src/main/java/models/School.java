package models;

import java.util.Collection;
import java.util.Map;

public class School {
    private final Collection<Room> rooms;

    public School(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }
}
