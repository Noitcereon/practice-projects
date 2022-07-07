package models;

import java.util.Collection;
import java.util.UUID;

public class Timetable implements IUuid {

    private String id;
    private final Collection<ScheduleItemInfo> itinerary;

    public Timetable(Collection<ScheduleItemInfo> itinerary){
        setId(UUID.randomUUID());
        this.itinerary = itinerary;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(UUID uuid) {
        this.id = uuid.toString();
    }

    public Collection<ScheduleItemInfo> getItinerary(){
        return itinerary;
    }
}
