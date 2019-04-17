import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class CalculateRegistrationPriceTest {

    @Test
    public void participantHaveNoAccommodationWithCompletePrice() {
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        Registration registration = new Registration(checkIn, AccommodationType.NONE);
        Assert.assertEquals(480, registration.getTotalPrice(new CheckIn(LocalDateTime.of(2019, 4, 14, 13, 0, 0))));
    }

    @Test
    public void participantHaveNoAccommodationWithoutLastMeal() {
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        Registration registration = new Registration(checkIn, AccommodationType.NONE);

        Assert.assertEquals(440, registration.getTotalPrice(new CheckIn(LocalDateTime.of(2019, 4, 14, 11, 0, 0))));
    }

    @Test
    public void participantHaveNoAccommodationWithoutFirstMeal() {
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 12, 20, 0, 0));
        Registration registration = new Registration(checkIn, AccommodationType.NONE);

        Assert.assertEquals(440, registration.getTotalPrice(new CheckIn(LocalDateTime.of(2019, 4, 14, 15, 0, 0))));
    }

    @Test
    public void participantHaveNoAccommodationWithoutFirstAndLastMeals() {
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 11, 23, 0, 0));
        Registration registration = new Registration(checkIn, AccommodationType.NONE);

        Assert.assertEquals(400, registration.getTotalPrice(new CheckIn(LocalDateTime.of(2019, 4, 14, 11, 0, 0))));
    }
}
