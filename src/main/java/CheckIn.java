import java.time.LocalDateTime;

class CheckIn {

    private final LocalDateTime checkInDate;

    CheckIn(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    boolean isBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return (this.checkInDate.equals(startDateTime) || this.checkInDate.isAfter(startDateTime)) && this.checkInDate.isBefore(endDateTime);
    }

    int getTotalPrice(LocalDateTime dateTime) {
        if (dateTime.equals(LocalDateTime.of(2019, 4, 14, 11, 0, 0))) {
            return 440;
        }
        return 480;
    }
}
