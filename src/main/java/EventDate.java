import java.time.LocalDateTime;

class EventDate {

    private final LocalDateTime date;

    EventDate(LocalDateTime date) {
        this.date = date;
    }

    boolean isBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return (this.date.equals(startDateTime) || this.date.isAfter(startDateTime)) && this.date.isBefore(endDateTime);
    }

    boolean isAfter(EventDate date) {
        return this.date.isAfter(date.date);
    }

    boolean isBefore(EventDate date) {
        return this.date.isBefore(date.date);
    }
}
