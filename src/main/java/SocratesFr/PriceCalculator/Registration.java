package SocratesFr.PriceCalculator;

import SocratesFr.DateInterval;

public class Registration {

    private final DateInterval attendance;
    private final AccommodationType accommodationType;

    Registration(AccommodationType accommodationType, DateInterval attendance) {
        this.accommodationType = accommodationType;
        this.attendance = attendance;
    }

    public int calculateTotalPrice(DateInterval mealServiceInterval) {
        MealsPricing mealsPricing = new MealsPricing(mealServiceInterval);
        return accommodationType.price + mealsPricing.calculate(attendance);
    }
}
