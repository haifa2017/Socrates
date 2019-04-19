package SocratesFr.PriceCalculator;

import SocratesFr.DateInterval;

public class RegistrationBuilder {
    private AccommodationType accommodationType;
    private DateInterval eventInterval;

    public RegistrationBuilder setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
        return this;
    }

    public RegistrationBuilder setEventInterval(DateInterval eventInterval) {
        this.eventInterval = eventInterval;
        return this;
    }

    public Registration createRegistration() {
        return new Registration(accommodationType, eventInterval);
    }
}