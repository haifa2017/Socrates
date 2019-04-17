import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class CalculateRegistrationPriceTest {

    @Test
    public void participantHaveNoAccommodationWithCompletePrice() {
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0));

        Assert.assertEquals(480, checkIn.getTotalPrice(LocalDateTime.of(2019, 4, 14, 12, 0, 0)));
    }

    @Test
    public void participantHaveNoAccommodationWithoutLastMeal() {
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0));

        Assert.assertEquals(440, checkIn.getTotalPrice(LocalDateTime.of(2019, 4, 14, 11, 0, 0)));
    }

    @Test
    public void participantHaveNoAccommodationWithoutFirstMeal() {
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 12, 20, 0, 0));

        Assert.assertEquals(440, checkIn.getTotalPrice(LocalDateTime.of(2019, 4, 14, 15, 0, 0)));
    }
}
