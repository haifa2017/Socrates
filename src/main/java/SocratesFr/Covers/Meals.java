package SocratesFr.Covers;

import java.util.Arrays;
import java.util.List;

class Meals {

    private List<Meal> vegetarians;

    Meals(Meal... meals) {
        this.vegetarians = Arrays.asList(meals);
    }

    Covers asCovers() {
        return new Covers(vegetarians.size());
    }
}
