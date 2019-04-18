import java.time.LocalDateTime;

class DateInterval {

    final public EventDate start;
    final public EventDate end;

    public DateInterval(LocalDateTime start, LocalDateTime end) {
        this.start = new EventDate(start);
        this.end = new EventDate(end);
    }
}
