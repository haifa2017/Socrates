import java.time.LocalDateTime;

class Demo {
    public static void main(String[] args) {
        CheckInRegistration registration = new CheckInRegistration(LocalDateTime.of(2019, 4, 11, 21, 0, 0));

        System.out.println("Cas avec 0 participants =>");
        System.out.println("Il faut " + registration.countColdMeals() + " repas froid.");
        System.out.println("");

        System.out.println("Cas avec 5 participants => ");
        System.out.println("Florian arrive à 23h");
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 23, 0, 0)));
        System.out.println("Laurent arrive à 18h");
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 18, 0, 0)));
        System.out.println("Houssam arrive à 9h");
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 9, 0, 0)));
        System.out.println("Jean-François à 21h");
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 11, 21, 0, 0)));
        System.out.println("Dorra arrive à 00h");
        registration.addCheckIn(new CheckIn(LocalDateTime.of(2019, 4, 12, 0, 0, 0)));

        System.out.println("Il faut " + registration.countColdMeals() + " repas froids.");
    }
}
