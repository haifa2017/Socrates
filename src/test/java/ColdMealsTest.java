import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ColdMealsTest {

    @Test
    public void test(){
        Assert.assertTrue(true);
    }

    @Test
    public void participantCheckInBefore9PM() {
        List<CheckIn> checkInList = new ArrayList<CheckIn>();
        checkInList.add(new CheckIn(new Date(2019, 4, 11, 16, 0, 0)));

        int count = CheckInManager.countColdMeals(checkInList);

        Assert.assertEquals(0, count);
    }

    @Test
    public void participantCheckInAfter9PM() {
        List<CheckIn> checkInList = new ArrayList<CheckIn>();
        checkInList.add(new CheckIn((new Date(2019, 4, 11, 22, 0, 0))));

        int count = CheckInManager.countColdMeals(checkInList);

        Assert.assertEquals(1, count);
    }
}
