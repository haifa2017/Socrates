package SocratesFr.Covers;

class Meal {
    private Diet diet;

    private Meal(Diet diet) {
        this.diet = diet;
    }

    static Meal of(Diet diet) {
        return new Meal(diet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meal meal = (Meal) o;

        return diet == meal.diet;
    }

    @Override
    public int hashCode() {
        return diet != null ? diet.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "\ndiet=" + diet +
                '}';
    }
}
