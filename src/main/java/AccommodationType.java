enum AccommodationType {
    NONE(240),
    SINGLE(610);

    private final int price;

    AccommodationType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
