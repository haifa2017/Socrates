enum AccommodationType {
    NONE(240);

    private final int price;

    AccommodationType(int i) {
        this.price = i;
    }

    public int getPrice() {
        return price;
    }
}
