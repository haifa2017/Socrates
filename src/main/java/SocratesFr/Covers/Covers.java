package SocratesFr.Covers;

import java.util.Objects;

class Covers {
    private long vegetarian;
    private long vegan;

    private Covers(long vegetarian, long vegan) {
        this.vegetarian = vegetarian;
        this.vegan = vegan;
    }

    static CoversBuilder builder() {
        return new CoversBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Covers covers = (Covers) o;
        return vegetarian == covers.vegetarian;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vegetarian);
    }

    static class CoversBuilder {
        private long vegetarian;
        private long vegan;

        CoversBuilder vegetarian(long vegetarian) {
            this.vegetarian = vegetarian;
            return this;
        }

        CoversBuilder vegan(long vegan) {
            this.vegan = vegan;
            return this;
        }

        Covers build() {
            return new Covers(vegetarian, vegan);
        }
    }
}
