import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ColdMealsTest {

    @Test
    public void participantCheckInBefore9PM() {
        List<CheckIn> checkInList = new ArrayList<>();
        checkInList.add(new CheckIn(LocalDateTime.of(2019, 4, 11, 16, 0, 0)));

        CheckInManager manager = CheckInManager.createManagerWithDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        int count = manager.countColdMeals(checkInList);

        assertEquals(0, count);
    }

    @Test
    public void participantCheckInAfter9PM() {
        List<CheckIn> checkInList = new ArrayList<>();
        checkInList.add(new CheckIn((LocalDateTime.of(2019, 4, 11, 22, 0, 0))));

        CheckInManager manager = CheckInManager.createManagerWithDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        int count = manager.countColdMeals(checkInList);

        assertEquals(1, count);
    }

    @Test
    public void participantCheckInAt9PM() {
        List<CheckIn> checkInList = new ArrayList<>();
        LocalDateTime datetime = LocalDateTime.of(2019, 4, 11, 21, 0, 0);
        checkInList.add(new CheckIn(datetime));

        CheckInManager manager = CheckInManager.createManagerWithDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        int count = manager.countColdMeals(checkInList);

        assertEquals(1, count);
    }

    @Test
    public void participantCheckInAtMidnight() {
        List<CheckIn> checkInList = new ArrayList<>();
        LocalDateTime datetime = LocalDateTime.of(2019, 4, 12, 0, 0, 0);
        checkInList.add(new CheckIn(datetime));

        CheckInManager manager = CheckInManager.createManagerWithDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        int count = manager.countColdMeals(checkInList);

        assertEquals(0, count);
    }

    @Test
    public void manyParticipantsCheckInAtDifferentTime() {
        List<CheckIn> checkInList = new ArrayList<>();
        checkInList.add(new CheckIn(LocalDateTime.of(2019, 4, 11, 9, 0, 0)));
        checkInList.add(new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0)));
        checkInList.add(new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 10, 0)));
        checkInList.add(new CheckIn(LocalDateTime.of(2019, 4, 12, 0, 0, 0)));
        checkInList.add(new CheckIn(LocalDateTime.of(2019, 4, 11, 13, 0, 0)));

        CheckInManager manager = CheckInManager.createManagerWithDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        int count = manager.countColdMeals(checkInList);
        assertEquals(2, count);
    }
}
