import java.time.LocalDateTime;

class CheckIn {

    private final LocalDateTime checkInDate;

    CheckIn(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    boolean isBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return (this.checkInDate.equals(startDateTime) || this.checkInDate.isAfter(startDateTime)) && this.checkInDate.isBefore(endDateTime);
    }

    boolean isAfter(LocalDateTime dateTime) {
        return this.checkInDate.isAfter(dateTime);
    }

    boolean isBefore(LocalDateTime dateTime) {
        return (this.checkInDate.equals(dateTime) || this.checkInDate.isBefore(dateTime));
    }
}
