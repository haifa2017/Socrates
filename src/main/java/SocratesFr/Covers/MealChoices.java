package SocratesFr.Covers;

import SocratesFr.Covers.Covers.CoversBuilder;

import java.util.*;

import static SocratesFr.Covers.Diet.values;

class MealChoices {

    private List<MealChoice> mealChoices;

    MealChoices(MealChoice... mealChoices) {
        this.mealChoices = Arrays.asList(mealChoices);
    }

    Covers asCovers() {
        CoversBuilder builder = Covers.builder();
        for (Diet diet : values()) {
            builder.add(diet, countMealsWithDiet(diet));
        }
        return builder.build();
    }

    Map<MealTime, Covers> asCoversByMealTime() {
        Map<MealTime, Covers> map = new HashMap<>();

        mealChoices.stream()
                .map(MealChoice::getMealTime)
                .distinct()
                .forEach(mealTime -> map.put(mealTime, asCovers(mealTime)));

        return map;
    }

    Covers asCovers(MealTime mealTime) {
        CoversBuilder builder = Covers.builder();
        for (Diet diet : values()) {
            builder.add(diet, countMealsWithDietFor(diet, mealTime));
        }
        return builder.build();
    }

    private long countMealsWithDietFor(Diet diet, MealTime mealTime) {
        return mealChoices.stream()
                .filter(mealChoice -> mealChoice.isFor(mealTime))
                .filter(mealChoice -> mealChoice.is(diet))
                .count();
    }

    private long countMealsWithDiet(Diet diet) {
        return mealChoices.stream()
                .filter(mealChoice -> mealChoice.is(diet))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealChoices mealChoices1 = (MealChoices) o;

        return Objects.equals(mealChoices, mealChoices1.mealChoices);
    }

    @Override
    public int hashCode() {
        return mealChoices != null ? mealChoices.hashCode() : 0;
    }
}
