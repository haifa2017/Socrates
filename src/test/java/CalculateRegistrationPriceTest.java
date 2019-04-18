import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class CalculateRegistrationPriceTest {

    private LocalDateTime firstMealServingTimeLimit;
    private LocalDateTime lastMealServingTime;

    @Before
    public void setupMealServingTime() {
        this.firstMealServingTimeLimit = LocalDateTime.of(2019, 4, 11, 21, 0, 0);
        this.lastMealServingTime = LocalDateTime.of(2019, 4, 14, 12, 0);
    }

    @Test
    public void participantHaveNoAccommodationWithCompletePrice() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        EventDate endDate = new EventDate(LocalDateTime.of(2019, 4, 14, 13, 0, 0));
        Registration registration = new Registration(checkIn, endDate, AccommodationType.NONE);

        DateInterval limits = new DateInterval(this.firstMealServingTimeLimit, this.lastMealServingTime);

        /*int mealCount = 6;
        if (this.checkIn.isAfter(firstMealServingTimeLimit)) {
            mealCount--;
        }
        if (this.checkOut.isBefore(lastMealServingTime)) {
            mealCount--;
        }
        return accommodationType.price + mealCount * 40;*/
        assertEquals(480, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveNoAccommodationWithoutLastMeal() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 11, 0, 0));

        Registration registration = new Registration(checkIn, checkOut, AccommodationType.NONE);
        DateInterval limits = new DateInterval(this.firstMealServingTimeLimit, this.lastMealServingTime);

        /*int mealCount = 6;
        if (this.checkIn.isAfter(firstMealServingTimeLimit)) {
            mealCount--;
        }
        if (this.checkOut.isBefore(lastMealServingTime)) {
            mealCount--;
        }
        return accommodationType.price + mealCount * 40;*/
        assertEquals(440, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveNoAccommodationWithoutFirstMeal() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 12, 20, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 15, 0, 0));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.NONE);

        DateInterval limits = new DateInterval(this.firstMealServingTimeLimit, this.lastMealServingTime);

        /*int mealCount = 6;
        if (this.checkIn.isAfter(firstMealServingTimeLimit)) {
            mealCount--;
        }
        if (this.checkOut.isBefore(lastMealServingTime)) {
            mealCount--;
        }
        return accommodationType.price + mealCount * 40;*/
        assertEquals(440, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveNoAccommodationWithoutFirstAndLastMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 23, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 11, 0, 0));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.NONE);

        DateInterval limits = new DateInterval(this.firstMealServingTimeLimit, this.lastMealServingTime);

        /*int mealCount = 6;
        if (this.checkIn.isAfter(firstMealServingTimeLimit)) {
            mealCount--;
        }
        if (this.checkOut.isBefore(lastMealServingTime)) {
            mealCount--;
        }
        return accommodationType.price + mealCount * 40;*/
        assertEquals(400, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveSingleRoomWithCompletePrice() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 13, 0, 0));

        Registration registration = new Registration(checkIn, checkOut, AccommodationType.SINGLE);
        DateInterval limits = new DateInterval(this.firstMealServingTimeLimit, this.lastMealServingTime);

        /*int mealCount = 6;
        if (this.checkIn.isAfter(firstMealServingTimeLimit)) {
            mealCount--;
        }
        if (this.checkOut.isBefore(lastMealServingTime)) {
            mealCount--;
        }
        return accommodationType.price + mealCount * 40;*/
        assertEquals(850, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveSingleRoomWithoutOneMeal() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 23, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 13, 0, 0));

        Registration registration = new Registration(checkIn, checkOut, AccommodationType.SINGLE);
        DateInterval limits = new DateInterval(this.firstMealServingTimeLimit, this.lastMealServingTime);

        /*int mealCount = 6;
        if (this.checkIn.isAfter(firstMealServingTimeLimit)) {
            mealCount--;
        }
        if (this.checkOut.isBefore(lastMealServingTime)) {
            mealCount--;
        }
        return accommodationType.price + mealCount * 40;*/
        assertEquals(810, registration.calculateTotalPrice(limits));
    }

    @Test
    public void participantHaveSingleRoomWithoutTwoMeals() {
        EventDate checkIn = new EventDate(LocalDateTime.of(2019, 4, 11, 23, 0, 0));
        EventDate checkOut = new EventDate(LocalDateTime.of(2019, 4, 14, 11, 0, 0));

        Registration registration = new Registration(checkIn, checkOut, AccommodationType.SINGLE);
        DateInterval limits = new DateInterval(this.firstMealServingTimeLimit, this.lastMealServingTime);

        assertEquals(770, registration.calculateTotalPrice(limits));
    }
}
