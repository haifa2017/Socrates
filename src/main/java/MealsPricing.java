class MealsPricing {

    private static final int MAX_MEAL_COUNT = 6;
    private static final int MEAL_PRICE = 40;
    DateInterval mealServiceInterval;

    public MealsPricing(DateInterval mealServiceInterval) {
        this.mealServiceInterval = mealServiceInterval;
    }

    int calculate(Registration registration) {
        int mealCount = calculateMealCount(registration);
        return mealCount * MEAL_PRICE;
    }

    private int calculateMealCount(Registration registration) {
        return MAX_MEAL_COUNT - calculateNumberNotTakenMeals(registration);
    }

    private int calculateNumberNotTakenMeals(Registration registration) {
        if (registration.attendance.isContainedBy(mealServiceInterval)) {
            return 2;
        }
        if (registration.attendance.overlaps(mealServiceInterval)) {
            return 1;
        }
        return 0;
    }
}
