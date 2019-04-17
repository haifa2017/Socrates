import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class CalculateRegistrationPriceTest {

    @Test
    public void participantHaveNoAccommodationWithCompletePrice() {
        CheckIn checkIn = new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0));

        Assert.assertEquals(480, checkIn.getTotalPrice());
    }
}
