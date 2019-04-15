import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

class CheckInManager {
    private LocalDateTime limitTime;

    private CheckInManager(LocalDateTime limitTime) {
        this.limitTime = limitTime;
    }

    static CheckInManager createManagerWithDate(LocalDateTime limitTime) {
        return new CheckInManager(limitTime);
    }

    int countColdMeals(List<CheckIn> checkInList) {
        LocalDateTime tomorrow = this.limitTime.plus(1, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS);
        long coldMealsCount = checkInList.stream().filter(
                checkIn -> checkIn.isEligibleToColdMeal(tomorrow, this.limitTime))
                .count();

        return (int) coldMealsCount;
    }

}
