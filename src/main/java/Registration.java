class Registration {

    public final DateInterval eventInterval;
    private AccommodationType accommodationType;

    Registration(AccommodationType accommodationType, DateInterval eventInterval) {
        this.accommodationType = accommodationType;
        this.eventInterval = eventInterval;
    }

    int calculateTotalPrice(DateInterval mealServiceInterval) {
        MealsPricing mealsPricing = new MealsPricing();
        return accommodationType.price + mealsPricing.calculateMealsPrice(mealServiceInterval, this);
    }

    public EventDate arrival() {
        return eventInterval.start;
    }

    public EventDate departure() {
        return eventInterval.end;
    }
}
