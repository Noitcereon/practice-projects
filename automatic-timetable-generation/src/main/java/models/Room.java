package models;

public class Room {
    private String id;
    private String name;
    private boolean isClassRoom;
    // private int personLimit;

    public Room(String id, String name){
        setId(id);
        setName(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isClassRoom() {
        return isClassRoom;
    }

    public void setClassRoom(boolean classRoom) {
        isClassRoom = classRoom;
    }
}
