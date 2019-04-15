import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class InvalidCheckInTest {

    @Test
    public void countEmptyCheckIn() {
        CheckInRegistration registration = new CheckInRegistration(LocalDateTime.of(2019, 4, 11, 21, 0, 0));
        registration.addCheckIn(new CheckIn(null));
        Assert.assertEquals(1, registration.countEmpty());
    }
}
