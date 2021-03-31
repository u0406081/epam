package vashetkov.lesson3.Comparators;

import vashetkov.lesson3.Human;
import java.util.Comparator;

public class ComparatorAddress implements Comparator<Human> {


    public int compare(Human h1, Human h2) {
        return h1.getAddress().toString().compareTo(h2.getAddress().toString());
    }
}

