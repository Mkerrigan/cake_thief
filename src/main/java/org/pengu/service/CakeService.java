package org.pengu.service;

import org.pengu.model.Cake;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CakeService {
    private LinkedList<Cake> sortedCakes;
    public int maxDuffelBagValue(List<Cake> cakeList, int weight) {

        //sort cakes by order
        class sortByValue implements Comparator<Cake> {
            @Override
            public int compare(Cake a,Cake b) {
                return a.getValue()/a.getWeight()-b.getValue()/b.getWeight();
            }
        }
        sortedCakes = new LinkedList(cakeList);
        Collections.sort(sortedCakes,new sortByValue());
        /*System.out.println("cakes sorted by value density");
        for(Cake cake : sortedCakes){
            System.out.println(cake);
        }*/
        return findMaxDuffelBagValue(weight);
    }
    int findMaxDuffelBagValue(int weight){
        int extraSpace  = weight%sortedCakes.getLast().getWeight();
        int value = weight/sortedCakes.getLast().getWeight() * sortedCakes.getLast().getValue();
        sortedCakes.removeLast();
        return extraSpace == 0? value:value + findMaxDuffelBagValue(extraSpace);
    }
}
