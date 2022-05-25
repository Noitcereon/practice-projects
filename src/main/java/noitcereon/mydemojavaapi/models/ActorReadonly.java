package noitcereon.mydemojavaapi.models;

import noitcereon.mydemojavaapi.models.entities.Actor;

public class ActorReadonly{
    public final String uuid;
    public final String firstName;
    public final String lastName;
    public final int age;

    public ActorReadonly(Actor actorEntity){
        this.uuid = actorEntity.getUuid();
        this.firstName = actorEntity.getFirstName();
        this.lastName = actorEntity.getLastName();
        this.age = actorEntity.getAge();
    }
}