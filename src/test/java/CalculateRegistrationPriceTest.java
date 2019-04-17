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
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        CheckIn endDate = new CheckIn(LocalDateTime.of(2019, 4, 14, 13, 0, 0));
        Registration registration = new Registration(checkIn, endDate, AccommodationType.NONE);

        assertEquals(480, registration.getTotalPrice(this.firstMealServingTimeLimit, this.lastMealServingTime));
    }

    @Test
    public void participantHaveNoAccommodationWithoutLastMeal() {
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        CheckIn checkOut = new CheckIn(LocalDateTime.of(2019, 4, 14, 11, 0, 0));

        Registration registration = new Registration(checkIn, checkOut, AccommodationType.NONE);
        assertEquals(440, registration.getTotalPrice(this.firstMealServingTimeLimit, this.lastMealServingTime));
    }

    @Test
    public void participantHaveNoAccommodationWithoutFirstMeal() {
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 12, 20, 0, 0));
        CheckIn checkOut = new CheckIn(LocalDateTime.of(2019, 4, 14, 15, 0, 0));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.NONE);

        assertEquals(440, registration.getTotalPrice(this.firstMealServingTimeLimit, this.lastMealServingTime));
    }

    @Test
    public void participantHaveNoAccommodationWithoutFirstAndLastMeals() {
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 11, 23, 0, 0));
        CheckIn checkOut = new CheckIn(LocalDateTime.of(2019, 4, 14, 11, 0, 0));
        Registration registration = new Registration(checkIn, checkOut, AccommodationType.NONE);

        assertEquals(400, registration.getTotalPrice(this.firstMealServingTimeLimit, this.lastMealServingTime));
    }
}
