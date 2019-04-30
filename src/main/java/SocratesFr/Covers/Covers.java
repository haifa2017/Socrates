package SocratesFr.Covers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Covers {

    private Map<Diet, Quantity> dietQuantity;
    private static final int QUANTITY_MIN = 1;

    private Covers(Map<Diet, Quantity> dietQuantity) {
        this.dietQuantity = new HashMap<>(dietQuantity);
    }

    static CoversBuilder builder() {
        return new CoversBuilder();
    }

    @Override
    public String toString() {
        return "Covers{" +
                "\ndietQuantity=" + dietQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Covers covers = (Covers) o;

        return Objects.equals(dietQuantity, covers.dietQuantity);
    }

    @Override
    public int hashCode() {
        return dietQuantity != null ? dietQuantity.hashCode() : 0;
    }

    static class CoversBuilder {
        private Map<Diet, Quantity> dietQuantity = new HashMap<>();

        CoversBuilder add(Diet diet, long quantity) {
            if (quantity < QUANTITY_MIN) {
                return this;
            }
            this.dietQuantity.put(diet, Quantity.of(quantity));
            return this;
        }

        Covers build() {
            return new Covers(this.dietQuantity);
        }
    }
}
