enum AccommodationType {
    NONE(240),
    SINGLE(610),
    DOUBLE(510);

    public final int price;

    AccommodationType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
