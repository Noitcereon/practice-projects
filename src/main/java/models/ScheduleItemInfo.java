package models;

public class ScheduleItemInfo {
    private String roomId;
    private String activityTitle;
    private Person host;
    private TimeSlot duration;

    public ScheduleItemInfo(String roomId, String activityTitle, Person host, TimeSlot duration) {
        this.roomId = roomId;
        this.activityTitle = activityTitle;
        this.host = host;
        this.duration = duration;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public Person getHost() {
        return host;
    }

    public void setHost(Person host) {
        this.host = host;
    }

    public TimeSlot getDuration() {
        return duration;
    }

    public void setDuration(TimeSlot duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ScheduleItemInfo{" +
                "roomId='" + roomId + '\'' +
                ", activityTitle='" + activityTitle + '\'' +
                ", host=" + host +
                ", duration=" + duration +
                '}';
    }
}
