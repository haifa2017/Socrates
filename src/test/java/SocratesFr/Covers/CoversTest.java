package SocratesFr.Covers;

import org.junit.Test;

import static SocratesFr.Covers.Diet.VEGAN;
import static SocratesFr.Covers.Diet.VEGETARIAN;
import static org.assertj.core.api.Assertions.assertThat;

public class CoversTest {

    @Test
    public void one_vegetarian_meal_return_one_vegetarian_cover() {
        Meals meals = new Meals(Meal.of(VEGETARIAN));

        Covers covers = meals.asCovers();

        Covers coverWithOneVegetarianMeal = Covers.builder().vegetarian(1).build();
        assertThat(covers).isEqualTo(coverWithOneVegetarianMeal);
    }

    @Test
    public void two_vegetarian_meals_return_two_vegetarian_meals() {
        Meals meals = new Meals(Meal.of(VEGETARIAN), Meal.of(VEGETARIAN));

        Covers covers = meals.asCovers();

        Covers coverWithTwoVegetarianMeals = Covers.builder().vegetarian(2).build();
        assertThat(covers).isEqualTo(coverWithTwoVegetarianMeals);
    }

    @Test
    public void one_vegetarian_and_one_vegan_meals_return_one_vegan_and_one_vegetarian_covers() {
        Meals meals = new Meals(
                Meal.of(VEGETARIAN),
                Meal.of(VEGAN));

        Covers covers = meals.asCovers();

        Covers coversWithOneVeganAndOneVegetarian = Covers.builder().vegetarian(1).vegan(1).build();
        assertThat(covers).isEqualTo(coversWithOneVeganAndOneVegetarian);
    }
}
