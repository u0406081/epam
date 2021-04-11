package vashetkov.lesson3.Comparators;

import vashetkov.lesson3.Human;

import java.util.Comparator;

public class ComparatorAge implements Comparator<Human> {

    public int compare(Human h1, Human h2) {
        return h1.getAge().compareTo(h2.getAge());
    }
}