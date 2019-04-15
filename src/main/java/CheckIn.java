import java.time.LocalDateTime;

class CheckIn {

    private final LocalDateTime checkInDate;

    CheckIn(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    public boolean isEligibleToColdMeal(LocalDateTime limitTime, LocalDateTime tomorrow) {
        return (this.checkInDate.equals(limitTime) || this.checkInDate.isAfter(limitTime)) && this.checkInDate.isBefore(tomorrow);
    }
}
