import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class CalculateRegistrationPriceTest {

    private LocalDateTime firstMealServingTimeLimit;
    private LocalDateTime lastMealServingTime;
    private DateInterval limits;

    @Before
    public void setupMealServingTime() {
        firstMealServingTimeLimit = LocalDateTime.of(2019, 4, 11, 21, 0, 0);
        lastMealServingTime = LocalDateTime.of(2019, 4, 14, 12, 0);
        limits = new DateInterval(new EventDate(firstMealServingTimeLimit), new EventDate(lastMealServingTime));
    }

    @Test
    public void noAccommodationWithAllMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        EventDate endDate = new EventDate(LocalDateTime.of(2019, 4, 14, 13, 0, 0));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.NONE).setEventInterval(new DateInterval(checkIn, endDate)).createRegistration();

        assertEquals(480, registration.calculateTotalPrice(limits));
    }

    @Test
    public void noAccommodationWithoutOneMeal() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 12, 20, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 15, 0, 0));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.NONE).setEventInterval(new DateInterval(checkIn, checkOut)).createRegistration();

        assertEquals(440, registration.calculateTotalPrice(limits));
    }

    @Test
    public void noAccommodationWithoutTwoMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 23, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 11, 0, 0));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.NONE).setEventInterval(new DateInterval(checkIn, checkOut)).createRegistration();

        assertEquals(400, registration.calculateTotalPrice(limits));
    }

    @Test
    public void singleRoomWithAllMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 13, 0, 0));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.SINGLE).setEventInterval(new DateInterval(checkIn, checkOut)).createRegistration();

        assertEquals(850, registration.calculateTotalPrice(limits));
    }

    @Test
    public void singleRoomWithoutOneMeal() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 23, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 13, 0, 0));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.SINGLE).setEventInterval(new DateInterval(checkIn, checkOut)).createRegistration();

        assertEquals(810, registration.calculateTotalPrice(limits));
    }

    @Test
    public void singleRoomWithoutTwoMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 23, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 11, 0, 0));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.SINGLE).setEventInterval(new DateInterval(checkIn, checkOut)).createRegistration();

        assertEquals(770, registration.calculateTotalPrice(limits));
    }

    @Test
    public void doubleRoomWithAllMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 20, 0, 0));
        EventDate checkOut = new EventDate((LocalDateTime.of(2019, 4, 14, 15, 0, 0)));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.DOUBLE).setEventInterval(new DateInterval(checkIn, checkOut)).createRegistration();

        assertEquals(750, registration.calculateTotalPrice(limits));
    }

    @Test
    public void doubleRoomWithoutOneMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 12, 10, 0, 0));
        EventDate checkOut = new EventDate((LocalDateTime.of(2019, 4, 14, 15, 0, 0)));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.DOUBLE).setEventInterval(new DateInterval(checkIn, checkOut)).createRegistration();

        assertEquals(710, registration.calculateTotalPrice(limits));
    }

    @Test
    public void doubleRoomWithoutTwoMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 12, 10, 0, 0));
        EventDate checkOut = new EventDate((LocalDateTime.of(2019, 4, 13, 23, 0, 0)));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.DOUBLE).setEventInterval(new DateInterval(checkIn, checkOut)).createRegistration();

        assertEquals(670, registration.calculateTotalPrice(limits));
    }

    @Test
    public void tripleRoomWithAllMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 18, 0, 0));
        EventDate checkOut = new EventDate((LocalDateTime.of(2019, 4, 14, 23, 0, 0)));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.TRIPLE).setEventInterval(new DateInterval(checkIn, checkOut)).createRegistration();

        assertEquals(650, registration.calculateTotalPrice(limits));
    }

    @Test
    public void tripleRoomWithoutOneMeal() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 18, 0, 0));
        EventDate checkOut = new EventDate((LocalDateTime.of(2019, 4, 14, 5, 0, 0)));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.TRIPLE).setEventInterval(new DateInterval(checkIn, checkOut)).createRegistration();

        assertEquals(610, registration.calculateTotalPrice(limits));
    }

    @Test
    public void tripleRoomWithoutTwoMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 12, 18, 0, 0));
        EventDate checkOut = new EventDate((LocalDateTime.of(2019, 4, 13, 23, 0, 0)));
        Registration registration = new RegistrationBuilder().setAccommodationType(AccommodationType.TRIPLE).setEventInterval(new DateInterval(checkIn, checkOut)).createRegistration();

        assertEquals(570, registration.calculateTotalPrice(limits));
    }

}
