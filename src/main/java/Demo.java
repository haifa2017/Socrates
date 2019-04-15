import java.time.LocalDateTime;
import java.util.Scanner;

class Demo {
    public static void main(String[] args) {
        CheckInRegistration registration = new CheckInRegistration();

        System.out.println("Cas avec 0 participants =>");
        System.out.println("Il faut " + registration.countColdMeals(LocalDateTime.of(2019, 4, 11, 21, 0, 0)) + " repas froid.");
        System.out.println("");
        new Scanner(System.in).nextLine();

        System.out.println("Cas avec 5 participants => ");
        System.out.println("Florian arrive à 23h");
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 23, 0, 0)));
        System.out.println("Laurent arrive à 18h");
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 18, 0, 0)));
        System.out.println("Houssam arrive à 9h");
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 9, 0, 0)));
        System.out.println("Jean-François à 21h");
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0)));
        System.out.println("Dorra arrive le soir à 00h");
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 12, 0, 0, 0)));
        System.out.println("Guillaume arrive le lendemain à 03h");
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 12, 3, 0, 0)));

        System.out.println("Il faut " + registration.countColdMeals(LocalDateTime.of(2019, 4, 11, 21, 0, 0)) + " repas froids.");
    }
}
