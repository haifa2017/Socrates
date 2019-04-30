package SocratesFr.Covers;

class Covers {
    private long vegetarian;
    private long vegan;
    private long pescatarian;

    private Covers(long vegetarian, long vegan, long pescatarian) {
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.pescatarian = pescatarian;
    }

    static CoversBuilder builder() {
        return new CoversBuilder();
    }

    @Override
    public String toString() {
        return "Covers{" +
                "\nvegetarian=" + vegetarian +
                ", \nvegan=" + vegan +
                ", \npescatarian=" + pescatarian +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Covers covers = (Covers) o;

        if (vegetarian != covers.vegetarian) return false;
        if (vegan != covers.vegan) return false;
        return pescatarian == covers.pescatarian;
    }

    @Override
    public int hashCode() {
        int result = (int) (vegetarian ^ (vegetarian >>> 32));
        result = 31 * result + (int) (vegan ^ (vegan >>> 32));
        result = 31 * result + (int) (pescatarian ^ (pescatarian >>> 32));
        return result;
    }

    static class CoversBuilder {
        private long vegetarian;
        private long vegan;
        private long pescatarian;

        CoversBuilder vegetarian(long vegetarian) {
            this.vegetarian = vegetarian;
            return this;
        }

        CoversBuilder vegan(long vegan) {
            this.vegan = vegan;
            return this;
        }

        CoversBuilder pescatarian(long pescatarian) {
            this.pescatarian = pescatarian;
            return this;
        }

        Covers build() {
            return new Covers(vegetarian, vegan, pescatarian);
        }
    }
}
