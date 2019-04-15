import java.time.LocalDateTime;

class CheckIn {

    private final LocalDateTime checkInDate;

    CheckIn(LocalDateTime checkInDate) {

        this.checkInDate = checkInDate;
    }

    public LocalDateTime getCheckInDate() {
        return this.checkInDate;
    }

    public boolean isEligibleToColdMeal(LocalDateTime tomorrow, LocalDateTime limitTime) {
        return (getCheckInDate().equals(limitTime) || getCheckInDate().isAfter(limitTime)) && getCheckInDate().isBefore(tomorrow);
    }
}
