package SocratesFr.Covers;

import org.junit.Test;

import java.time.LocalDateTime;

import static SocratesFr.Covers.Diet.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MealChoicesTest {

    private static final MealTime LUNCH = MealTime.of(LocalDateTime.of(2019, 1, 1, 12, 1));
    private static final MealTime DINNER = MealTime.of(LocalDateTime.of(2019, 1, 1, 19, 1));

    @Test
    public void one_vegetarian_meal_return_one_vegetarian_cover() {
        MealChoices mealChoices = new MealChoices(MealChoice.of(VEGETARIAN, LUNCH));

        Covers covers = mealChoices.asCovers();

        Covers coverWithOneVegetarianMeal = Covers.builder().add(VEGETARIAN, 1).build();
        assertThat(covers).isEqualTo(coverWithOneVegetarianMeal);
    }

    @Test
    public void two_vegetarian_meals_return_two_vegetarian_meals() {
        MealChoices mealChoices = new MealChoices(MealChoice.of(VEGETARIAN, DINNER), MealChoice.of(VEGETARIAN, DINNER));

        Covers covers = mealChoices.asCovers();

        Covers coverWithTwoVegetarianMeals = Covers.builder().add(VEGETARIAN, 2).build();
        assertThat(covers).isEqualTo(coverWithTwoVegetarianMeals);
    }

    @Test
    public void one_vegetarian_and_one_vegan_meals_return_one_vegan_and_one_vegetarian_covers() {
        MealChoices mealChoices = new MealChoices(
                MealChoice.of(VEGETARIAN, LUNCH),
                MealChoice.of(VEGAN, LUNCH));

        Covers covers = mealChoices.asCovers();

        Covers coversWithOneVeganAndOneVegetarian = Covers.builder()
                .add(VEGETARIAN, 1)
                .add(VEGAN, 1)
                .build();
        assertThat(covers).isEqualTo(coversWithOneVeganAndOneVegetarian);
    }

    @Test
    public void one_pescatarian_meal_return_one_pescatarian_cover() {
        MealChoices mealChoices = new MealChoices(MealChoice.of(PESCATARIAN, LUNCH));

        Covers covers = mealChoices.asCovers();

        Covers OnePescatarianCover = Covers.builder().add(PESCATARIAN, 1).build();
        assertThat(covers).isEqualTo(OnePescatarianCover);
    }

    @Test
    public void one_omnivore_meal_return_one_omnivore_cover() {
        MealChoices mealChoices = new MealChoices(MealChoice.of(OMNIVORE, LUNCH));

        Covers covers = mealChoices.asCovers();

        Covers OneOmnivore = Covers.builder().add(OMNIVORE, 1).build();
        assertThat(covers).isEqualTo(OneOmnivore);
    }

    @Test
    public void one_omnivore_and_zero_vegan_is_equal_to_one_omnivore_cover() {
        Covers oneOmnivore = Covers.builder().add(OMNIVORE, 1).build();
        Covers oneOmnivoreAndZeroVegan = Covers.builder()
                .add(OMNIVORE, 1)
                .add(VEGAN, 0)
                .build();

        assertThat(oneOmnivoreAndZeroVegan).isEqualTo(oneOmnivore);
    }

    @Test
    public void meal_choices_for_a_specific_meal_time() {
        MealChoices choices = new MealChoices(
                MealChoice.of(VEGAN, LUNCH),
                MealChoice.of(VEGAN, DINNER));

        Covers covers = choices.asCovers(LUNCH);

        Covers coversExpected = Covers.builder().add(VEGAN, 1).build();
        assertThat(covers).isEqualTo(coversExpected);
    }
}
