package SocratesFr.Covers;

import java.util.Objects;

class MealChoice {
    private Diet diet;

    private MealChoice(Diet diet) {
        this.diet = diet;
    }

    static MealChoice of(Diet diet) {
        return new MealChoice(diet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealChoice mealChoice = (MealChoice) o;

        return diet == mealChoice.diet;
    }

    @Override
    public int hashCode() {
        return diet != null ? diet.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MealChoice{" +
                "\ndiet=" + diet +
                '}';
    }

    boolean is(Diet diet) {
        return Objects.equals(this.diet, diet);
    }
}
