class Registration {

    private EventDate checkIn;
    private EventDate checkOut;
    private AccommodationType accommodationType;

    Registration(EventDate checkIn, EventDate checkOut, AccommodationType accommodationType) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.accommodationType = accommodationType;
    }

    int CalculateTotalPrice(DateInterval interval) {
        int mealCount = 6;
        if (interval.contains(checkIn)) {
            mealCount--;
        }
        if (interval.contains(checkOut)) {
            mealCount--;
        }
        return accommodationType.price + mealCount * 40;
    }
}
