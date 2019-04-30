package SocratesFr.Covers;

import java.time.LocalDateTime;

class MealTime {

    private LocalDateTime dateTime;

    private MealTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    static MealTime of(LocalDateTime dateTime) {
        return new MealTime(dateTime);
    }

    @Override
    public String toString() {
        return "MealTime=" + dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealTime mealTime = (MealTime) o;

        return dateTime != null ? dateTime.equals(mealTime.dateTime) : mealTime.dateTime == null;
    }

    @Override
    public int hashCode() {
        return dateTime != null ? dateTime.hashCode() : 0;
    }
}
