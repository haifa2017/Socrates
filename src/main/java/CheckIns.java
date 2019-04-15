import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class CheckIns {
    private final List<CheckIn> checkInList;

    CheckIns() {
        this.checkInList = new ArrayList<>();
    }

    int countCheckInsAfter(LocalDateTime time) {
        LocalDateTime nextDay = time.plus(1, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS);
        long coldMealsCount = this.checkInList.stream()
                .filter(checkIn -> checkIn.isBetween(time, nextDay))
                .count();

        return (int) coldMealsCount;
    }

    void addCheckIn(CheckIn checkIn) {
        this.checkInList.add(checkIn);
    }
}
