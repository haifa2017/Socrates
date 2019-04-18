
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

    public boolean overlaps(DateInterval interval) {
        boolean overlapAtStart = interval.start.isBefore(start) && interval.end.isBefore(end) && interval.start.isBefore(end);
        boolean overlapAtEnd = interval.start.isAfter(start) && interval.end.isAfter(end) && interval.start.isBefore(end);

        return overlapAtStart || overlapAtEnd;
    }
}
