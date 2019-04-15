import java.time.LocalDateTime;
import java.util.Scanner;

class Demo {
    public static void main(String[] args) {
        CheckIns checkIns = new CheckIns();

        System.out.println("Cas avec 0 participants =>");
        System.out.println("Il faut " + checkIns.countCheckInsAfter(LocalDateTime.of(2019, 4, 11, 21, 0, 0)) + " repas froid.");
        System.out.println();
        new Scanner(System.in).nextLine();

        System.out.println("Cas avec 5 participants => ");
        System.out.println("Florian arrive à 23h");
        checkIns.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 23, 0, 0)));
        System.out.println("Laurent arrive à 18h");
        checkIns.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 18, 0, 0)));
        System.out.println("Houssam arrive à 9h");
        checkIns.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 9, 0, 0)));
        System.out.println("Jean-François à 21h");
        checkIns.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0)));
        System.out.println("Dorra arrive le soir à 00h");
        checkIns.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 12, 0, 0, 0)));
        System.out.println("Guillaume arrive le lendemain à 03h");
        checkIns.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 12, 3, 0, 0)));

        System.out.println("Il faut " + checkIns.countCheckInsAfter(LocalDateTime.of(2019, 4, 11, 21, 0, 0)) + " repas froids.");
    }
}
