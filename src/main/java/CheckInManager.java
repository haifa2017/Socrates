import java.util.Date;
import java.util.List;

class CheckInManager {

    static int countColdMeals(List<CheckIn> checkInList) {
        CheckIn checkIn = checkInList.get(0);
        Date checkInDate = checkIn.getCheckInDate();

        Date limitTime = new Date(2019, 4, 11, 21, 0, 0);
        if (checkInDate.equals(limitTime) || checkInDate.after(limitTime)) {
            return 1;
        }

        return 0;
    }
}
