package enums;

public enum CustomDayOfWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    final Integer label;
    CustomDayOfWeek(Integer label){
        this.label = label;
    }
}
