package SocratesFr;

public class DateInterval {

    private final EventDate start;
    private final EventDate end;

    public DateInterval(EventDate start, EventDate end) {
        this.start = start;
        this.end = end;
    }

    public boolean isContainedBy(DateInterval interval) {
        return start.isAfter(interval.start) && end.isBefore(interval.end);
    }

    public boolean overlaps(DateInterval interval) {
        boolean overlapAtStart = interval.start.isBefore(start) && interval.end.isBetween(start, end);
        boolean overlapAtEnd = interval.start.isBetween(start, end) && interval.end.isAfter(end);

        return overlapAtStart || overlapAtEnd;
    }
}
