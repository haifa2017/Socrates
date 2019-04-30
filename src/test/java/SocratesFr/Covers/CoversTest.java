package SocratesFr.Covers;

import org.junit.Test;

import static SocratesFr.Covers.Diet.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CoversTest {

    @Test
    public void one_vegetarian_meal_return_one_vegetarian_cover() {
        Meals meals = new Meals(Meal.of(VEGETARIAN));

        Covers covers = meals.asCovers();

        Covers coverWithOneVegetarianMeal = Covers.builder().add(VEGETARIAN, 1).build();
        assertThat(covers).isEqualTo(coverWithOneVegetarianMeal);
    }

    @Test
    public void two_vegetarian_meals_return_two_vegetarian_meals() {
        Meals meals = new Meals(Meal.of(VEGETARIAN), Meal.of(VEGETARIAN));

        Covers covers = meals.asCovers();

        Covers coverWithTwoVegetarianMeals = Covers.builder().add(VEGETARIAN, 2).build();
        assertThat(covers).isEqualTo(coverWithTwoVegetarianMeals);
    }

    @Test
    public void one_vegetarian_and_one_vegan_meals_return_one_vegan_and_one_vegetarian_covers() {
        Meals meals = new Meals(
                Meal.of(VEGETARIAN),
                Meal.of(VEGAN));

        Covers covers = meals.asCovers();

        Covers coversWithOneVeganAndOneVegetarian = Covers.builder()
                .add(VEGETARIAN, 1)
                .add(VEGAN, 1)
                .build();
        assertThat(covers).isEqualTo(coversWithOneVeganAndOneVegetarian);
    }

    @Test
    public void one_pescatarian_meal_return_one_pescatarian_cover() {
        Meals meals = new Meals(Meal.of(PESCATARIAN));

        Covers covers = meals.asCovers();

        Covers OnePescatarianCover = Covers.builder().add(PESCATARIAN, 1).build();
        assertThat(covers).isEqualTo(OnePescatarianCover);
    }
}
