package org.pengu.model;

import java.util.ArrayList;
import java.util.List;

public class DuffelBag {
    private List<Cake> cakesInBag = new ArrayList<Cake>();
    private int maxWeight;
    private int weight = 0;

    public DuffelBag(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<Cake> getCakesInBag() {
        return cakesInBag;
    }

    public boolean tryToAddCakeToBag(Cake cake) {
        if (this.weight + cake.getWeight() <= this.maxWeight) {
            this.cakesInBag.add(cake);
            this.weight += cake.getWeight();
            return true;
        } else {
            return false;
        }

    }
}
