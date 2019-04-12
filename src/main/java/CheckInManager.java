import java.util.Date;
import java.util.List;

class CheckInManager {

    static int countColdMeals(List<CheckIn> checkInList) {
        Date limitTime = new Date(2019, 4, 11, 21, 0, 0);
        Date tomorrow = new Date(2019, 4, 12, 0, 0, 0);
        long count = checkInList.stream().filter(
                checkIn -> (checkIn.getCheckInDate().equals(limitTime) || checkIn.getCheckInDate().after(limitTime)) && checkIn.getCheckInDate().before(tomorrow))
                .count();

        return (int) count;
    }
}
