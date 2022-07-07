package enums;

public enum Role {
    STAFF,
    STUDENT,
    TEACHER;

    @Override
    public String toString() {
        if (this == Role.STAFF) return "Staff";
        if (this == Role.STUDENT) return "Student";
        if (this == Role.TEACHER) return "Teacher";
        return null;
    }
}
