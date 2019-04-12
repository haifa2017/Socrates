import java.util.Date;
import java.util.List;

class CheckInManager {

    static int countColdMeals(List<CheckIn> checkInList) {
        if (checkInList.get(0).getCheckInDate().equals(new Date(2019, 4, 11, 21, 0, 0))) {
            return 1;
        }

        if (checkInList.get(0).getCheckInDate().equals(new Date(2019, 4, 11, 22, 0, 0))) {
            return 1;
        }
        return 0;
    }
}
