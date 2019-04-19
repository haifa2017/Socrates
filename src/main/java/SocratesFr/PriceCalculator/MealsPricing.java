package SocratesFr.PriceCalculator;

import SocratesFr.DateInterval;

class MealsPricing {

    private static final int MAX_MEAL_COUNT = 6;
    private static final int MEAL_PRICE = 40;
    private final DateInterval mealServiceInterval;

    MealsPricing(DateInterval mealServiceInterval) {
        this.mealServiceInterval = mealServiceInterval;
    }

    int calculate(DateInterval attendance) {
        int mealCount = calculateMealCount(attendance);
        return mealCount * MEAL_PRICE;
    }

    private int calculateMealCount(DateInterval attendance) {
        return MAX_MEAL_COUNT - calculateNumberNotTakenMeals(attendance);
    }

    private int calculateNumberNotTakenMeals(DateInterval attendance) {
        if (attendance.isContainedBy(mealServiceInterval)) {
            return 2;
        }
        if (attendance.overlaps(mealServiceInterval)) {
            return 1;
        }
        return 0;
    }
}
