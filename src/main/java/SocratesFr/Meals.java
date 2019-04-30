package SocratesFr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Meals {

    List<Meal> vegetarians = new ArrayList<>();

    Meals(Meal vegetarian) {
    }

    Meals(Meal... vegetarians) {
        this.vegetarians = Arrays.asList(vegetarians);
    }

    Covers asCovers() {
        if (vegetarians.size() > 0) {
            return new Covers(2);
        }
        return new Covers(1);
    }
}
