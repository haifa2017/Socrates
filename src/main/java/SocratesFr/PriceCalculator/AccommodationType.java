package SocratesFr.PriceCalculator;

public enum AccommodationType {
    NONE(240),
    SINGLE(610),
    DOUBLE(510),
    TRIPLE(410);

    public final int price;

    AccommodationType(int price) {
        this.price = price;
    }

}
