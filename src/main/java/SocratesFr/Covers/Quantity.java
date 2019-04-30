package SocratesFr.Covers;

class Quantity {
    private long quantity;

    private Quantity(long quantity) {
        this.quantity = quantity;
    }

    static Quantity of(long quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity can not be negative");
        }
        return new Quantity(quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity quantity1 = (Quantity) o;

        return quantity == quantity1.quantity;
    }

    @Override
    public int hashCode() {
        return (int) (quantity ^ (quantity >>> 32));
    }
}
