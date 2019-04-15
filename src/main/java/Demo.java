import java.time.LocalDateTime;
import java.util.ArrayList;

class Demo {
    public static void main(String[] args) {
        CheckInManager manager = CheckInManager.createManagerWithDate(LocalDateTime.of(2019, 4, 11, 21, 0, 0));

        System.out.println("Cas avec 0 participants =>");
        System.out.println("Il faut " + manager.countColdMeals(new ArrayList<>()) + " repas froid.");
        System.out.println("");

        System.out.println("Cas avec 5 participants => ");
        ArrayList<CheckIn> checkInList = new ArrayList<>();
        System.out.println("Florian arrive à 23h");
        checkInList.add(new CheckIn(LocalDateTime.of(2019, 4, 11, 23, 0, 0)));
        System.out.println("Laurent arrive à 18h");
        checkInList.add(new CheckIn(LocalDateTime.of(2019, 4, 11, 18, 0, 0)));
        System.out.println("Houssam arrive à 9h");
        checkInList.add(new CheckIn(LocalDateTime.of(2019, 4, 11, 9, 0, 0)));
        System.out.println("Jean-François à 21h");
        checkInList.add(new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0)));
        System.out.println("Dorra arrive à 00h");
        checkInList.add(new CheckIn(LocalDateTime.of(2019, 4, 12, 0, 0, 0)));

        System.out.println("Il faut " + manager.countColdMeals(checkInList) + " repas froids.");
    }
}
