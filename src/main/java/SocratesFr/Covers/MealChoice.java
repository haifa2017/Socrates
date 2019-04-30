package SocratesFr.Covers;

import java.util.Objects;

class MealChoice {
    private Diet diet;
    private final MealTime mealTime;

    private MealChoice(Diet diet) {
        this.diet = diet;
        mealTime = null;
    }

    private MealChoice(Diet diet, MealTime mealTime) {
        this.diet = diet;
        this.mealTime = mealTime;
    }

    static MealChoice of(Diet diet) {
        return new MealChoice(diet);
    }

    static MealChoice of(Diet diet, MealTime mealTime) {
        return new MealChoice(diet, mealTime);
    }

    boolean isFor(MealTime mealTime) {
        return Objects.equals(mealTime, this.mealTime);
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
