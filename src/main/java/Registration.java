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

    int getPriceForRoomAndMeals(LocalDateTime firstMealServingTimeLimit, LocalDateTime lastMealServingTime) {
        int mealCount = 6;
        if (this.checkIn.isAfter(firstMealServingTimeLimit)) {
            mealCount--;
        }
        if (this.checkOut.isBefore(lastMealServingTime)) {
            mealCount--;
        }
        return this.accommodationType.getPrice() + mealCount * 40;
    }
}
