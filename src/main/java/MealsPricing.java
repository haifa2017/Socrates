class MealsPricing {

    private static final int MAX_MEAL_COUNT = 6;
    private static final int MEAL_PRICE = 40;

    public int calculateMealsPrice(DateInterval mealServiceInterval, Registration registration) {
        int mealCount = calculateMealCount(mealServiceInterval, registration);
        return mealCount * MEAL_PRICE;
    }

    private int calculateMealCount(DateInterval mealServiceInterval, Registration registration) {
        return MAX_MEAL_COUNT - calculateNumberNotTakenMeals(mealServiceInterval, registration);
    }

    private int calculateNumberNotTakenMeals(DateInterval mealServiceInterval, Registration registration) {
        if (registration.eventInterval.isContainedBy(mealServiceInterval)) {
            return 2;
        }
        int numberNotTakenMeals = 0;
        if (registration.arrival().isAfter(mealServiceInterval.start)) {
            numberNotTakenMeals++;
        }
        if (registration.departure().isBefore(mealServiceInterval.end)) {
            numberNotTakenMeals++;
        }
        return numberNotTakenMeals;
    }
}
