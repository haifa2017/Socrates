import java.time.LocalDateTime;

class DateInterval {

    final public EventDate start;
    final public EventDate end;

    public DateInterval(LocalDateTime start, LocalDateTime end) {
        this.start = new EventDate(start);
        this.end = new EventDate(end);
    }

    public DateInterval(EventDate start, EventDate end) {
        this.start = start;
        this.end = end;
    }
}
