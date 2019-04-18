
class DateInterval {

    final EventDate start;
    final EventDate end;

    public DateInterval(EventDate start, EventDate end) {
        this.start = start;
        this.end = end;
    }

    public boolean isContainedBy(DateInterval interval) {
        return start.isAfter(interval.start) && end.isBefore(interval.end);
    }
}
