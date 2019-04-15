import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class CheckInRegistration {
    private List<CheckIn> checkInList;

    public CheckInRegistration() {
        this.checkInList = new ArrayList<>();
    }

    int countColdMeals(LocalDateTime limitTime) {
        LocalDateTime tomorrow = limitTime.plus(1, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS);
        long coldMealsCount = this.checkInList.stream().filter(
                checkIn -> checkIn.isBetween(limitTime, tomorrow))
                .count();

        return (int) coldMealsCount;
    }

    void addCheckIn(CheckIn checkIn) {
        this.checkInList.add(checkIn);
    }

}
