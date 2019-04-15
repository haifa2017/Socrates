import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ColdMealsTest {

    @Test
    public void participantCheckInBefore9PM() {
        CheckInRegistration registration = new CheckInRegistration(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 16, 0, 0)));

        int count = registration.countColdMeals();

        assertEquals(0, count);
    }

    @Test
    public void participantCheckInAfter9PM() {
        CheckInRegistration registration = new CheckInRegistration(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        registration.addCheckIn(new CheckIn((LocalDateTime.of(2019, 4, 11, 22, 0, 0))));

        int count = registration.countColdMeals();

        assertEquals(1, count);
    }

    @Test
    public void participantCheckInAt9PM() {
        CheckInRegistration registration = new CheckInRegistration(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        LocalDateTime datetime = LocalDateTime.of(2019, 4, 11, 21, 0, 0);
        registration.addCheckIn(new CheckIn(datetime));

        int count = registration.countColdMeals();

        assertEquals(1, count);
    }

    @Test
    public void participantCheckInAtMidnight() {
        CheckInRegistration registration = new CheckInRegistration(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        LocalDateTime datetime = LocalDateTime.of(2019, 4, 12, 0, 0, 0);
        registration.addCheckIn(new CheckIn(datetime));

        int count = registration.countColdMeals();

        assertEquals(0, count);
    }

    @Test
    public void manyParticipantsCheckInAtDifferentTime() {
        CheckInRegistration registration = new CheckInRegistration(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 9, 0, 0)));
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0)));
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 10, 0)));
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 12, 0, 0, 0)));
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 13, 0, 0)));

        int count = registration.countColdMeals();
        assertEquals(2, count);
    }
}
