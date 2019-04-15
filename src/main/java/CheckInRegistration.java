import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class CheckInRegistration {
    private LocalDateTime limitTime;
    private List<CheckIn> checkInList;

    public CheckInRegistration(LocalDateTime limitTime) {
        this.limitTime = limitTime;
        this.checkInList = new ArrayList<>();
    }

    int countColdMeals() {
        LocalDateTime tomorrow = this.limitTime.plus(1, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS);
        long coldMealsCount = this.checkInList.stream().filter(
                checkIn -> checkIn.isEligibleToColdMeal(this.limitTime, tomorrow))
                .count();

        return (int) coldMealsCount;
    }

    void addCheckIn(CheckIn checkIn) {
        this.checkInList.add(checkIn);
    }
}
