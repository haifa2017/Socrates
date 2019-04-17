import java.time.LocalDateTime;

class CheckIn {

    private final LocalDateTime checkInDate;

    CheckIn(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    boolean isBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return (this.checkInDate.equals(startDateTime) || this.checkInDate.isAfter(startDateTime)) && this.checkInDate.isBefore(endDateTime);
    }

    int getTotalPrice() {
        return 240;
    }
}
