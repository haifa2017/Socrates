package SocratesFr.Covers;

import SocratesFr.Covers.Covers.CoversBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static SocratesFr.Covers.Diet.values;

class Meals {

    private List<Meal> meals;

    Meals(Meal... meals) {
        this.meals = Arrays.asList(meals);
    }

    Covers asCovers() {
        CoversBuilder builder = Covers.builder();
        for (Diet diet : values()) {
            builder.add(diet, countMealsWithDiet(diet));
        }
        return builder.build();
    }

    private long countMealsWithDiet(Diet diet) {
        return meals.stream()
                .filter(meal -> meal.is(diet))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meals meals1 = (Meals) o;

        return Objects.equals(meals, meals1.meals);
    }

    @Override
    public int hashCode() {
        return meals != null ? meals.hashCode() : 0;
    }
}
