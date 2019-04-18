import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class CalculateRegistrationPriceTest {

    private LocalDateTime firstMealServingTimeLimit;
    private LocalDateTime lastMealServingTime;

    @Before
    public void setupMealServingTime() {
        firstMealServingTimeLimit = LocalDateTime.of(2019, 4, 11, 21, 0, 0);
        lastMealServingTime = LocalDateTime.of(2019, 4, 14, 12, 0);
    }

    @Test
    public void participantHaveNoAccommodationWithCompletePrice() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        EventDate endDate = new EventDate(LocalDateTime.of(2019, 4, 14, 13, 0, 0));
        Registration registration = new Registration(checkIn, endDate, AccommodationType.NONE);
        DateInterval limits = new DateInterval(firstMealServingTimeLimit, lastMealServingTime);

        assertEquals(480, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveNoAccommodationWithoutLastMeal() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 11, 0, 0));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.NONE);
        DateInterval limits = new DateInterval(firstMealServingTimeLimit, lastMealServingTime);

        assertEquals(440, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveNoAccommodationWithoutFirstMeal() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 12, 20, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 15, 0, 0));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.NONE);
        DateInterval limits = new DateInterval(firstMealServingTimeLimit, lastMealServingTime);

        assertEquals(440, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveNoAccommodationWithoutFirstAndLastMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 23, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 11, 0, 0));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.NONE);
        DateInterval limits = new DateInterval(firstMealServingTimeLimit, lastMealServingTime);

        assertEquals(400, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveSingleRoomWithCompletePrice() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 13, 0, 0));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.SINGLE);
        DateInterval limits = new DateInterval(firstMealServingTimeLimit, lastMealServingTime);

        assertEquals(850, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveSingleRoomWithoutOneMeal() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 23, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 13, 0, 0));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.SINGLE);
        DateInterval limits = new DateInterval(firstMealServingTimeLimit, lastMealServingTime);

        assertEquals(810, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveSingleRoomWithoutTwoMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 23, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 11, 0, 0));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.SINGLE);
        DateInterval limits = new DateInterval(firstMealServingTimeLimit, lastMealServingTime);

        assertEquals(770, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveDoubleRoomWithCompletePrice() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 20, 0, 0));
        EventDate checkOut = new EventDate((LocalDateTime.of(2019, 4, 14, 15, 0, 0)));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.DOUBLE);
        DateInterval limits = new DateInterval(firstMealServingTimeLimit, lastMealServingTime);

        assertEquals(750, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveDoubleRoomWithoutOneMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 12, 10, 0, 0));
        EventDate checkOut = new EventDate((LocalDateTime.of(2019, 4, 14, 15, 0, 0)));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.DOUBLE);
        DateInterval limits = new DateInterval(firstMealServingTimeLimit, lastMealServingTime);

        assertEquals(710, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveDoubleRoomWithoutTwoMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 12, 10, 0, 0));
        EventDate checkOut = new EventDate((LocalDateTime.of(2019, 4, 13, 23, 0, 0)));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.DOUBLE);
        DateInterval limits = new DateInterval(firstMealServingTimeLimit, lastMealServingTime);

        assertEquals(670, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveTripleRoomWithCompletePrice() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 18, 0, 0));
        EventDate checkOut = new EventDate((LocalDateTime.of(2019, 4, 14, 23, 0, 0)));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.TRIPLE);
        DateInterval limits = new DateInterval(firstMealServingTimeLimit, lastMealServingTime);

        assertEquals(650, registration.calculateTotalPrice(limits));
    }
}
