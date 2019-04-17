import java.time.LocalDateTime;

class Registration {

    private CheckIn checkIn;
    private AccommodationType accommodationType;

    Registration(CheckIn checkIn, AccommodationType accommodationType) {
        this.checkIn = checkIn;
        this.accommodationType = accommodationType;
    }

    int getTotalPrice(CheckIn endDate) {
        if (this.checkIn.isAfter(LocalDateTime.of(2019, 4, 11, 21, 0, 0)) && endDate.isBefore(LocalDateTime.of(2019, 4, 14, 12, 0))) {
            return this.accommodationType.getPrice() + 4 * 40; // 240 + (4*40)
        }
        if (this.checkIn.isAfter(LocalDateTime.of(2019, 4, 11, 21, 0)) || endDate.isBefore(LocalDateTime.of(2019, 4, 14, 12, 0))) {
            return this.accommodationType.getPrice() + 5 * 40; // 240 + (5*40)
        }
        return this.accommodationType.getPrice() + 6 * 40; // 240 + 6*40
    }
}
