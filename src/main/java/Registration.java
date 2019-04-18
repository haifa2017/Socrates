class Registration {

    public static final int MAX_MEAL_COUNT = 6;
    public static final int MEAL_PRICE = 40;
    private EventDate checkIn;
    private EventDate checkOut;
    private AccommodationType accommodationType;

    Registration(EventDate checkIn, EventDate checkOut, AccommodationType accommodationType) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.accommodationType = accommodationType;
    }

    int calculateTotalPrice(DateInterval mealServiceInterval) {
        return accommodationType.price + calculateMealsPrice(mealServiceInterval);
    }

    private int calculateMealsPrice(DateInterval mealServiceInterval) {
        int mealCount = calculateMealCount(mealServiceInterval);
        return mealCount * MEAL_PRICE;
    }

    private int calculateMealCount(DateInterval mealServiceInterval) {
        return MAX_MEAL_COUNT - calculateNumberNotTakenMeals(mealServiceInterval);
    }

    private int calculateNumberNotTakenMeals(DateInterval mealServiceInterval) {
        int numberNotTakenMeals = 0;
        if (checkIn.isAfter(mealServiceInterval.start)) {
            numberNotTakenMeals++;
        }
        if (checkOut.isBefore(mealServiceInterval.end)) {
            numberNotTakenMeals++;
        }
        return numberNotTakenMeals;
    }
}
