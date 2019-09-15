package org.pengu.model;

public class Cake {

    private int weight;
    private int value;

    public Cake(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public float getValueOverWeight() {
        return this.value / this.weight;
    }
}
