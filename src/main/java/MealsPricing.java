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
        int numberNotTakenMeals = 0;
        EventDate date1 = new EventDate(mealServiceInterval.start);
        if (registration.checkIn.isAfter(date1)) {
            numberNotTakenMeals++;
        }
        EventDate date = new EventDate(mealServiceInterval.end);
        if (registration.checkOut.isBefore(date)) {
            numberNotTakenMeals++;
        }
        return numberNotTakenMeals;
    }
}
