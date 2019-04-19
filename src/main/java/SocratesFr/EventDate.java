package SocratesFr;

import java.time.LocalDateTime;

public class EventDate {

    private final LocalDateTime date;

    public EventDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isBetween(EventDate startDateTime, EventDate endDateTime) {
        return this.date.isAfter(startDateTime.date) && this.date.isBefore(endDateTime.date);
    }

    public boolean isAfter(EventDate date) {
        return this.date.isAfter(date.date);
    }

    public boolean isBefore(EventDate date) {
        return this.date.isBefore(date.date);
    }

    public boolean isEqual(EventDate date) {
        return this.date.isEqual(date.date);
    }
}
