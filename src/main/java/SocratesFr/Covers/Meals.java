package SocratesFr.Covers;

import java.util.Arrays;
import java.util.List;

import static SocratesFr.Covers.Diet.*;

class Meals {

    private List<Meal> meals;

    Meals(Meal... meals) {
        this.meals = Arrays.asList(meals);
    }

    Covers asCovers() {
        return Covers.builder()
                .vegetarian(countMealsWithDiet(VEGETARIAN))
                .vegan(countMealsWithDiet(VEGAN))
                .pescatarian(countMealsWithDiet(PESCATARIAN))
                .build();
    }

    private long countMealsWithDiet(Diet diet) {
        return meals.stream()
                .filter(meal -> meal.is(diet))
                .count();
    }
}
