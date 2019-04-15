import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class CheckInRegistration {
    private List<CheckIn> checkInList;

    CheckInRegistration() {
        this.checkInList = new ArrayList<>();
    }

    int countColdMeals(LocalDateTime coldMealServingTime) {
        LocalDateTime nextDay = coldMealServingTime.plus(1, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS);
        long coldMealsCount = this.checkInList.stream().filter(
                checkIn -> checkIn.isBetween(coldMealServingTime, nextDay))
                .count();

        return (int) coldMealsCount;
    }

    void addCheckIn(CheckIn checkIn) {
        this.checkInList.add(checkIn);
    }
}
