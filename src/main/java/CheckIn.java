import java.util.Date;

class CheckIn {

    private final Date checkInDate;

    CheckIn(Date checkInDate) {

        this.checkInDate = checkInDate;
    }

    public Date getCheckInDate() {
        return this.checkInDate;
    }
}
