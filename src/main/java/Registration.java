import java.time.LocalDateTime;

class Registration {

    private CheckIn checkIn;
    private CheckIn checkOut;
    private AccommodationType accommodationType;

    Registration(CheckIn checkIn, CheckIn checkOut, AccommodationType accommodationType) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.accommodationType = accommodationType;
    }

    int getTotalPrice(LocalDateTime firstMealServingTimeLimit, LocalDateTime lastMealServingTime) {
        if (this.checkIn.isAfter(firstMealServingTimeLimit) && this.checkOut.isBefore(lastMealServingTime)) {
            return this.accommodationType.getPrice() + 4 * 40; // 240 + (4*40)
        }
        if (this.checkIn.isAfter(firstMealServingTimeLimit) || this.checkOut.isBefore(lastMealServingTime)) {
            return this.accommodationType.getPrice() + 5 * 40; // 240 + (5*40)
        }
        return this.accommodationType.getPrice() + 6 * 40; // 240 + 6*40
    }
}
