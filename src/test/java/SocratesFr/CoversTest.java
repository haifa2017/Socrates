package SocratesFr;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CoversTest {

    @Test
    public void one_vegetarian_meal_return_one_vegetarian_cover() {
        Meals meals = new Meals(Meal.VEGETARIAN);

        Covers covers = meals.asCovers();

        Covers coverWithOneVegetarianMeal = new Covers(1);
        Assertions.assertThat(covers).isEqualTo(coverWithOneVegetarianMeal);
    }

}
