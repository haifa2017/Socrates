package SocratesFr;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CoversTest {

    @Test
    public void mealsVegetargian() {
        Meals meals = new Meals(Meal.VEGETARIAN);

        Covers covers = meals.asCovers();

        Covers coverWithOneVegetarianMeal = new Covers(1);
        Assertions.assertThat(covers).isEqualTo(coverWithOneVegetarianMeal);
    }
}
