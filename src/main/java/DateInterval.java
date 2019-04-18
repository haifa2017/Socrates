import java.time.LocalDateTime;

class DateInterval {

    final public LocalDateTime start;
    final public LocalDateTime end;

    public DateInterval(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    boolean contains(EventDate date) {
        return date.isAfter(start) && date.isBefore(end);
    }
}
