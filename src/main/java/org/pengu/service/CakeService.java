package org.pengu.service;

import org.pengu.model.Cake;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

 class CakeService {
     int maxDuffelBagValue(List<Cake> cakeList, int weight) {
         LinkedList<Cake> sortedCakes;
         //sort cakes by order
        class sortByValue implements Comparator<Cake> {
            @Override
            public int compare(Cake a, Cake b) {
                return a.getValue() / a.getWeight() - b.getValue() / b.getWeight();
            }
        }
        sortedCakes = new LinkedList<>(cakeList);
        sortedCakes.sort(new sortByValue());
        /*System.out.println("cakes sorted by value density");
        for(Cake cake : sortedCakes){
            System.out.println(cake);
        }*/
        class duffelBag {
            private LinkedList<Cake> sortedCakes;
            private int weight;
            private duffelBag(LinkedList<Cake> sortedCakes,int weight){
                this.sortedCakes = sortedCakes;
                this.weight = weight;
            }
            private int maxValue() {
                Cake cake = sortedCakes.getLast();
                int extraSpace = weight % cake.getWeight();
                int value = weight / cake.getWeight() * cake.getValue();
                sortedCakes.removeLast();
                if(extraSpace != 0 && !sortedCakes.isEmpty()){
                    int multipleCakesValue = new duffelBag(new LinkedList<>(sortedCakes),extraSpace + cake.getWeight()).maxValue();
                    if(multipleCakesValue >= cake.getValue()) return value - cake.getValue() + multipleCakesValue;
                }
                return extraSpace == 0 || sortedCakes.isEmpty() ? value: value + new duffelBag(sortedCakes,extraSpace).maxValue();
            }
        }
        return new duffelBag(sortedCakes,weight).maxValue();
     }
 }

