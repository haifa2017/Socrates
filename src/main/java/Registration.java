class Registration {

    final EventDate checkIn;
    final EventDate checkOut;
    private AccommodationType accommodationType;

    Registration(EventDate checkIn, EventDate checkOut, AccommodationType accommodationType) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.accommodationType = accommodationType;
    }

    int calculateTotalPrice(DateInterval mealServiceInterval) {
        MealsPricing mealsPricing = new MealsPricing();
        return accommodationType.price + mealsPricing.calculateMealsPrice(mealServiceInterval, this);
    }

}
