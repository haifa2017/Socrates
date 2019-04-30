package SocratesFr.Covers;

import java.util.Objects;

class Covers {
    private final int numberVegetarianMeals;
    private int vegan;

    Covers(int numberVegetarianMeals) {
        this.numberVegetarianMeals = numberVegetarianMeals;
    }

    Covers(int vegetarian, int vegan) {
        numberVegetarianMeals = vegetarian;
        this.vegan = vegan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Covers covers = (Covers) o;
        return numberVegetarianMeals == covers.numberVegetarianMeals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberVegetarianMeals);
    }
}
