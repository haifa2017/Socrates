import java.time.LocalDateTime;

class EventDate {

    private final LocalDateTime date;

    EventDate(LocalDateTime date) {
        this.date = date;
    }

    boolean isBetween(EventDate startDateTime, EventDate endDateTime) {
        return this.date.isAfter(startDateTime.date) && this.date.isBefore(endDateTime.date);
    }

    boolean isAfter(EventDate date) {
        return this.date.isAfter(date.date);
    }

    boolean isBefore(EventDate date) {
        return this.date.isBefore(date.date);
    }

    boolean isEqual(EventDate date) {
        return this.date.isEqual(date.date);
    }
}
