package SocratesFr;

import SocratesFr.ColdMeals.CheckIns;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ColdMealsTest {

    @Test
    public void participantCheckInBefore9PM() {
        CheckIns checkIns = new CheckIns();
        checkIns.addCheckIn(new EventDate(LocalDateTime.of(2019, 4, 11, 16, 0, 0)));

        int count = checkIns.countCheckInsAfter(LocalDateTime.of(2019, 4, 11, 21, 0, 0));

        assertEquals(0, count);
    }

    @Test
    public void participantCheckInAfter9PM() {
        CheckIns checkIns = new CheckIns();
        checkIns.addCheckIn(new EventDate((LocalDateTime.of(2019, 4, 11, 22, 0, 0))));

        int count = checkIns.countCheckInsAfter(LocalDateTime.of(2019, 4, 11, 21, 0, 0));

        assertEquals(1, count);
    }

    @Test
    public void participantCheckInAt9PM() {
        CheckIns checkIns = new CheckIns();
        LocalDateTime datetime = LocalDateTime.of(2019, 4, 11, 21, 0, 0);
        checkIns.addCheckIn(new EventDate(datetime));

        int count = checkIns.countCheckInsAfter(LocalDateTime.of(2019, 4, 11, 21, 0, 0));

        assertEquals(1, count);
    }

    @Test
    public void participantCheckInAtMidnight() {
        CheckIns checkIns = new CheckIns();
        LocalDateTime datetime = LocalDateTime.of(2019, 4, 12, 0, 0, 0);
        checkIns.addCheckIn(new EventDate(datetime));

        int count = checkIns.countCheckInsAfter(LocalDateTime.of(2019, 4, 11, 21, 0, 0));

        assertEquals(0, count);
    }

    @Test
    public void manyParticipantsCheckInAtDifferentTime() {
        CheckIns checkIns = new CheckIns();
        checkIns.addCheckIn(new EventDate(LocalDateTime.of(2019, 4, 11, 9, 0, 0)));
        checkIns.addCheckIn(new EventDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0)));
        checkIns.addCheckIn(new EventDate(LocalDateTime.of(2019, 4, 11, 21, 10, 0)));
        checkIns.addCheckIn(new EventDate(LocalDateTime.of(2019, 4, 12, 0, 0, 0)));

        int count = checkIns.countCheckInsAfter(LocalDateTime.of(2019, 4, 11, 21, 0, 0));

        assertEquals(2, count);
    }
}
