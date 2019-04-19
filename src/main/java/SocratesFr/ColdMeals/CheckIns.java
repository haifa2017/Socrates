package SocratesFr.ColdMeals;

import SocratesFr.EventDate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CheckIns {
    private final List<EventDate> checkInList;

    public CheckIns() {
        this.checkInList = new ArrayList<>();
    }

    public int countCheckInsAfter(LocalDateTime time) {
        LocalDateTime nextDay = time.plus(1, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS);
        long coldMealsCount = checkInList.stream()
                .filter(checkIn -> checkIn.isBetween(new EventDate(time), new EventDate(nextDay)) || checkIn.isEqual(new EventDate(time)))
                .count();

        return (int) coldMealsCount;
    }

    public void addCheckIn(EventDate checkIn) {
        checkInList.add(checkIn);
    }
}
