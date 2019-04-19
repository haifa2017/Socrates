class Registration {

    final DateInterval attendance;
    private final AccommodationType accommodationType;

    Registration(AccommodationType accommodationType, DateInterval attendance) {
        this.accommodationType = accommodationType;
        this.attendance = attendance;
    }

    int calculateTotalPrice(DateInterval mealServiceInterval) {
        MealsPricing mealsPricing = new MealsPricing(mealServiceInterval);
        return accommodationType.price + mealsPricing.calculate(this);
    }
}
