package org.pengu.model;

import java.util.Comparator;

public class CakeValueOverWeight implements Comparator<Cake> {
    public int compare(Cake cakeA, Cake cakeB) {
        return cakeB.getValueOverWeight() - cakeA.getValueOverWeight();
    }
}
